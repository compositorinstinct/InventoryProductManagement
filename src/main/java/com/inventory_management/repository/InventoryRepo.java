package com.inventory_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.inventory_management.model.InventoryModel;


@Repository
public interface InventoryRepo extends JpaRepository<InventoryModel, Long>{

}
