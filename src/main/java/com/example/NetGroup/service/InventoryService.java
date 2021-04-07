package com.example.NetGroup.service;


import com.example.NetGroup.model.InventoryLocation;
import com.example.NetGroup.repo.InventoryLocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Service
public class InventoryService {

    private final InventoryLocationRepo inventoryLocationRepo;

    //New instance of location
    @Autowired
    public InventoryService(InventoryLocationRepo inventoryLocationRepo) {
        this.inventoryLocationRepo = inventoryLocationRepo;
    }

    public InventoryLocation createNewLocation(InventoryLocation inventoryLocation) {
        return inventoryLocationRepo.save(inventoryLocation);
    };

    //Get list of all locations
    public List<InventoryLocation> findAllInventory_locations() {
        return inventoryLocationRepo.findAll();
    }

    //Update location
    public InventoryLocation updateInventory_location(InventoryLocation inventory_location) {
        return inventoryLocationRepo.save(inventory_location);
    }

    //Find location by id
    public InventoryLocation findLocationById(Long id) throws UserPrincipalNotFoundException {
        return inventoryLocationRepo.findById(id).orElseThrow(() ->
                new UserPrincipalNotFoundException("Location by id" + id + "Was not found"));
    }

    //delete Location
    public void deleteLocation(Long id) {
        inventoryLocationRepo.deleteById(id);
    }

}
