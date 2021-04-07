package com.example.NetGroup.controllers;


import com.example.NetGroup.model.InventoryLocation;
import com.example.NetGroup.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

//Inventory related endpoints

@RestController
@RequestMapping("/inventory")
public class LocationController {
    private final InventoryService inventoryService;

    public LocationController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<InventoryLocation>> getAllLocations() {
        List<InventoryLocation> inventoryList = inventoryService.findAllInventory_locations();
        //return
        return new ResponseEntity<>(inventoryList, HttpStatus.OK);
    }

    //Find user by id
    @GetMapping("/find/{id}")
    public ResponseEntity<InventoryLocation> getLocationById(@PathVariable("id") Long id) throws UserPrincipalNotFoundException {
        InventoryLocation inventoryLocation = inventoryService.findLocationById(id);
        //return
        return new ResponseEntity<>(inventoryLocation, HttpStatus.OK);
    }

    //Add user
    //We use post request here because we are making change in database
    @PostMapping("/add")
    public ResponseEntity<InventoryLocation> addLocation(@RequestBody InventoryLocation inventoryLocation) {
        InventoryLocation newLocation = inventoryService.createNewLocation(inventoryLocation);
        //return
        return new ResponseEntity<>(newLocation, HttpStatus.CREATED);
    }

    //Delete user
    @PutMapping("/update")
    public ResponseEntity<InventoryLocation> upDateLocation(InventoryLocation inventoryLocation) {
        InventoryLocation updatedLocation = inventoryService.updateInventory_location(inventoryLocation);
        //return
        return new ResponseEntity<>(updatedLocation, HttpStatus.OK);
    }

    //Delete method wont return anything
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLocation(@PathVariable("id") Long id) {
        inventoryService.deleteLocation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
