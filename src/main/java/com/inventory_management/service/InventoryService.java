package com.inventory_management.service;

import java.util.List;

import com.inventory_management.model.InventoryModel;

public interface InventoryService {

	List<InventoryModel> getAllProductDetails();
	String createProductDetails(InventoryModel model);
	String updateProductDetails(Long productId, InventoryModel model);
	String partialUpdateProduct(Long productId, InventoryModel model);
	InventoryModel getProductDetailById(Long productId);
	

	
}
