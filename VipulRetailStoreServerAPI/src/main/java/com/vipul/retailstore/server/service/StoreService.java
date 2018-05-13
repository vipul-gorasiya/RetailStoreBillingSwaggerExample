package com.vipul.retailstore.server.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipul.retailstore.server.model.Bill;
import com.vipul.retailstore.server.model.Bill.StatusEnum;
import com.vipul.retailstore.server.model.BillItem;
import com.vipul.retailstore.server.model.Product;
import com.vipul.retailstore.server.repository.BillItemRepository;
import com.vipul.retailstore.server.repository.BillRepository;
import com.vipul.retailstore.server.repository.ProductRepository;

@Service
@Transactional
public class StoreService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private BillRepository billRepository;
	@Autowired
	private BillItemRepository billItemRepository;

	public Product getProduct(Long id) {
		return EntityModelMapper.mapToModel(productRepository.findOne(id));
	}

	public Bill createBill() {
		return EntityModelMapper.mapToModel(billRepository.save(new com.vipul.retailstore.server.entity.Bill()));
	}

	public Bill completeBill(Bill bill) {
		bill.setStatus(StatusEnum.COMPLETED);
		return EntityModelMapper.mapToModel(billRepository.save(EntityModelMapper.mapToEntity(bill)));
	}

	public Bill addProductToBill(Bill bill, final Long productId) {
		Optional<BillItem> findExistingEntry = null;
		if (bill.getBillItems() != null) {
			findExistingEntry = bill.getBillItems().stream().filter(item -> item.getProductId() == productId)
					.findFirst();
		}
		BillItem billItem = null;
		Product product = getProduct(productId);
		if (findExistingEntry.isPresent()) {
			billItem = findExistingEntry.get();
			billItem.setQuantity(billItem.getQuantity() + 1);
			billItem.setItemCost(billItem.getItemCost() + product.getCost());
			billItem.setItemSalesTax(billItem.getItemSalesTax() + product.getSalesTax());
			billItemRepository.save(EntityModelMapper.mapToEntity(billItem));
			bill.setTotalCost(bill.getTotalCost() + product.getCost());
			bill.setTotalSalesTax(bill.getTotalSalesTax() + product.getCost());
		} else {
			billItem = new BillItem();
			billItem.setBillId(bill.getId());
			billItem.setProductId(productId);
			billItem.setStatus(com.vipul.retailstore.server.model.BillItem.StatusEnum.ADDED);
			billItem.setQuantity(1L);
			com.vipul.retailstore.server.entity.BillItem savedEntity = billItemRepository
					.save(EntityModelMapper.mapToEntity(billItem));
			billItem.setId(savedEntity.getId());
			billItem.setItemCost(product.getCost());
			billItem.setItemSalesTax(product.getSalesTax());
			bill.addBillItemsItem(billItem);
		}
		return bill;
	}

	public Bill removeProductFromBill(Bill bill, final Long productId) {
		Optional<BillItem> findExistingEntry = null;
		if (bill.getBillItems() != null) {
			findExistingEntry = bill.getBillItems().stream().filter(item -> item.getProductId() == productId)
					.findFirst();
		}
		BillItem billItem = null;
		if (findExistingEntry.isPresent()) {
			billItem = findExistingEntry.get();
			billItem.setStatus(com.vipul.retailstore.server.model.BillItem.StatusEnum.DELETED);
			billItemRepository.save(EntityModelMapper.mapToEntity(billItem));
			bill.deleteBillItem(billItem);
		}
		return bill;
	}
}
