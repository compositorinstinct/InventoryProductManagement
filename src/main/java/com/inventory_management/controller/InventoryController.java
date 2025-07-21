package com.inventory_management.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.inventory_management.model.InventoryModel;
import com.inventory_management.service.InventoryService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class InventoryController {

	@Autowired
	InventoryService service;
	
	@GetMapping("/viewall")
	public List<InventoryModel> getAllProductsDetails(){
		return service.getAllProductDetails();
	}
	
	@PostMapping("/create")
	public String createProductDetails(@RequestBody InventoryModel model) {
		return service.createProductDetails(model);
	}
	
	@PutMapping("/update/{productId}")
	public String updateProductDetails(@PathVariable Long productId, @RequestBody InventoryModel model) {
		return service.updateProductDetails(productId, model);
	}
	
	@PatchMapping("/patch/{productId}")
	public String partialUpdateProduct(@PathVariable Long productId, @RequestBody InventoryModel model) {
		return service.partialUpdateProduct(productId,model);
	}
	
	@GetMapping("/{productId}")
	public InventoryModel getProductDetailsById(@PathVariable Long productId) {
		return service.getProductDetailById(productId);
	}
	
}
