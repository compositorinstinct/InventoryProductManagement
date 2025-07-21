package com.inventory_management.serviceimpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory_management.model.InventoryModel;
import com.inventory_management.repository.InventoryRepo;
import com.inventory_management.service.InventoryService;

@Service
public class InventoryServiceImplementation implements InventoryService{
	
	@Autowired
	private InventoryRepo repo;

	@Override
	public List<InventoryModel> getAllProductDetails() {  return repo.findAll(); }

	@Override
	public String createProductDetails(InventoryModel model) {
		repo.save(model);
		return "Created Successfully";
	}

	@Override
	public String updateProductDetails(Long productId, InventoryModel model) {
		InventoryModel existing = repo.findById(productId).orElse(null);
		existing.setName(model.getName());
		existing.setQuantity(model.getQuantity());
		existing.setStock(model.getStock());
		repo.save(existing);
		return "UPDATED SUCCESSFULLY";
	}

	@Override
	public String partialUpdateProduct(Long productId, InventoryModel model) {
		
		InventoryModel existing = repo.findById(productId).orElse(null);
		if(existing.getName()!=null && model.getName().isBlank()) {
			existing.setName(model.getName());
		}
		
		if(existing.getQuantity() != 0) {
			existing.setQuantity(model.getQuantity());
		}
		
		if(existing.getStock() != 0) {
			existing.setStock(model.getStock());
		}
		
		repo.save(existing);
		
		return "UPDATED SUCCESSFULLLY";
	}

	@Override
	public InventoryModel getProductDetailById(Long productId) {
		return repo.findById(productId).orElse(null);
	}



	
}
