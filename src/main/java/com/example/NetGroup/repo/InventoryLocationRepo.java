package com.example.NetGroup.repo;


import com.example.NetGroup.model.InventoryLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryLocationRepo extends JpaRepository<InventoryLocation, Long> {
}
