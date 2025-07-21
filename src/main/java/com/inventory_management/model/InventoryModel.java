package com.inventory_management.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "inventory_model")
public class InventoryModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	
	@NotBlank(message = "Name is Required")
	private String name;
	
	@Min(value = 0)
	@NotNull(message = "Quatity is required")
	private int quantity;
	
	@Min(value = 1, message = "stoke must be 1" )
	private int stock;
	private LocalDateTime createdTimestamp;
	private LocalDateTime updatedTimestamp;
	
	
	@PrePersist
	public void onCreate() {
		this.createdTimestamp=LocalDateTime.now();
		this.updatedTimestamp=LocalDateTime.now();
	}
	
	@PreUpdate
	public void onUpdate() { this.updatedTimestamp=LocalDateTime.now(); }

	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDateTime getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public LocalDateTime getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(LocalDateTime updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}
	
	
	
	
	
}
