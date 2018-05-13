package com.vipul.retailstore.server.service;

import com.vipul.retailstore.server.model.Bill;
import com.vipul.retailstore.server.model.BillItem;
import com.vipul.retailstore.server.model.Product;

public interface EntityModelMapper {

	public static Product mapToModel(com.vipul.retailstore.server.entity.Product entity) {
		if (entity == null) {
			return null;
		}
		Product model = new Product();
		model.setCost(entity.getCost());
		model.setId(entity.getId());
		model.setName(entity.getName());
		model.setProductCategory(entity.getProductCategory());
		return model;
	}

	public static com.vipul.retailstore.server.entity.Product mapToEntity(Product model) {
		if (model == null) {
			return null;
		}
		com.vipul.retailstore.server.entity.Product entity = new com.vipul.retailstore.server.entity.Product();
		entity.setCost(model.getCost());
		entity.setId(model.getId());
		entity.setName(model.getName());
		entity.setProductCategory(model.getProductCategory());
		return entity;
	}

	public static Bill mapToModel(com.vipul.retailstore.server.entity.Bill entity) {
		if (entity == null) {
			return null;
		}
		Bill model = new Bill();
		model.setId(entity.getId());
		model.setStatus(entity.getStatus());
		return model;
	}

	public static com.vipul.retailstore.server.entity.Bill mapToEntity(Bill model) {
		if (model == null) {
			return null;
		}
		com.vipul.retailstore.server.entity.Bill entity = new com.vipul.retailstore.server.entity.Bill();
		entity.setId(model.getId());
		entity.setStatus(model.getStatus());
		return entity;
	}

	public static BillItem mapToModel(com.vipul.retailstore.server.entity.BillItem entity) {
		if (entity == null) {
			return null;
		}
		BillItem model = new BillItem();
		model.setId(entity.getId());
		model.setBillId(entity.getBillId());
		model.setProductId(entity.getProductId());
		model.setQuantity(entity.getQuantity());
		model.setStatus(entity.getStatus());
		return model;
	}

	public static com.vipul.retailstore.server.entity.BillItem mapToEntity(BillItem model) {
		if (model == null) {
			return null;
		}
		com.vipul.retailstore.server.entity.BillItem entity = new com.vipul.retailstore.server.entity.BillItem();
		entity.setId(model.getId());
		entity.setBillId(model.getBillId());
		entity.setProductId(model.getProductId());
		entity.setQuantity(model.getQuantity());
		entity.setStatus(model.getStatus());
		return entity;
	}
}
