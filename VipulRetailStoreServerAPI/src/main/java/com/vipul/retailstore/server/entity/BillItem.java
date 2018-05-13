package com.vipul.retailstore.server.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vipul.retailstore.server.model.BillItem.StatusEnum;

/**
 * BillItem
 */
@Entity
@Table(name = "billitem")
public class BillItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;
	private Long billId = null;
	private Double itemCost = null;
	private Double itemSalesTax = null;
	@Enumerated(EnumType.STRING)
	private StatusEnum status = null;
	private Long productId = null;
	private Long quantity = null;

	public BillItem billId(Long billId) {
		this.billId = billId;
		return this;
	}

	/**
	 * Get billId
	 * 
	 * @return billId
	 **/
	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public BillItem id(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BillItem itemCost(Double itemCost) {
		this.itemCost = itemCost;
		return this;
	}

	/**
	 * Get itemCost
	 * 
	 * @return itemCost
	 **/
	public Double getItemCost() {
		return itemCost;
	}

	public void setItemCost(Double itemCost) {
		this.itemCost = itemCost;
	}

	public BillItem itemSalesTax(Double itemSalesTax) {
		this.itemSalesTax = itemSalesTax;
		return this;
	}

	/**
	 * Get itemSalesTax
	 * 
	 * @return itemSalesTax
	 **/
	public Double getItemSalesTax() {
		return itemSalesTax;
	}

	public void setItemSalesTax(Double itemSalesTax) {
		this.itemSalesTax = itemSalesTax;
	}

	public BillItem status(StatusEnum status) {
		this.status = status;
		return this;
	}

	/**
	 * Bill Item Status
	 * 
	 * @return status
	 **/
	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public BillItem productId(Long productId) {
		this.productId = productId;
		return this;
	}

	/**
	 * Get productId
	 * 
	 * @return productId
	 **/
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	
	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BillItem billItem = (BillItem) o;
		return Objects.equals(this.billId, billItem.billId) && Objects.equals(this.id, billItem.id) && Objects.equals(this.quantity, billItem.quantity)
				&& Objects.equals(this.itemCost, billItem.itemCost)
				&& Objects.equals(this.itemSalesTax, billItem.itemSalesTax)
				&& Objects.equals(this.status, billItem.status) && Objects.equals(this.productId, billItem.productId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(billId, id, quantity, itemCost, itemSalesTax, status, productId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class BillItem {\n");

		sb.append("    billId: ").append(toIndentedString(billId)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
		sb.append("    itemCost: ").append(toIndentedString(itemCost)).append("\n");
		sb.append("    itemSalesTax: ").append(toIndentedString(itemSalesTax)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
