package com.example.NetGroup.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.NetGroup.model.InventoryLocation;
import com.example.NetGroup.repo.InventoryLocationRepo;
import com.example.NetGroup.service.InventoryService;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class LocationControllerTest {
    @Test
    public void testGetAllLocations() {
        InventoryLocationRepo inventoryLocationRepo = mock(InventoryLocationRepo.class);
        when(inventoryLocationRepo.findAll()).thenReturn(new ArrayList<InventoryLocation>());
        ResponseEntity<List<InventoryLocation>> actualAllLocations = (new LocationController(
                new InventoryService(inventoryLocationRepo))).getAllLocations();
        assertEquals("<200 OK OK,[],[]>", actualAllLocations.toString());
        assertTrue(actualAllLocations.hasBody());
        assertEquals(HttpStatus.OK, actualAllLocations.getStatusCode());
        verify(inventoryLocationRepo).findAll();
    }

    @Test
    public void testGetLocationById() throws UserPrincipalNotFoundException {
        InventoryLocation inventoryLocation = new InventoryLocation();
        inventoryLocation.setId(123L);
        InventoryLocationRepo inventoryLocationRepo = mock(InventoryLocationRepo.class);
        when(inventoryLocationRepo.findById((Long) any())).thenReturn(Optional.<InventoryLocation>of(inventoryLocation));
        ResponseEntity<InventoryLocation> actualLocationById = (new LocationController(
                new InventoryService(inventoryLocationRepo))).getLocationById(123L);
        assertEquals("<200 OK OK,new Location{ /id= 123/name= null/createdBy= null/},[]>", actualLocationById.toString());
        assertEquals(HttpStatus.OK, actualLocationById.getStatusCode());
        assertTrue(actualLocationById.hasBody());
        verify(inventoryLocationRepo).findById((Long) any());
    }

    @Test
    public void testAddLocation() {
        InventoryLocation inventoryLocation = new InventoryLocation();
        inventoryLocation.setId(123L);
        InventoryLocationRepo inventoryLocationRepo = mock(InventoryLocationRepo.class);
        when(inventoryLocationRepo.save((InventoryLocation) any())).thenReturn(inventoryLocation);
        LocationController locationController = new LocationController(new InventoryService(inventoryLocationRepo));
        ResponseEntity<InventoryLocation> actualAddLocationResult = locationController.addLocation(new InventoryLocation());
        assertEquals("<201 CREATED Created,new Location{ /id= 123/name= null/createdBy= null/},[]>",
                actualAddLocationResult.toString());
        assertEquals(HttpStatus.CREATED, actualAddLocationResult.getStatusCode());
        assertTrue(actualAddLocationResult.hasBody());
        verify(inventoryLocationRepo).save((InventoryLocation) any());
    }

    @Test
    public void testUpDateLocation() {
        InventoryLocation inventoryLocation = new InventoryLocation();
        inventoryLocation.setId(123L);
        InventoryLocationRepo inventoryLocationRepo = mock(InventoryLocationRepo.class);
        when(inventoryLocationRepo.save((InventoryLocation) any())).thenReturn(inventoryLocation);
        LocationController locationController = new LocationController(new InventoryService(inventoryLocationRepo));
        ResponseEntity<InventoryLocation> actualUpDateLocationResult = locationController
                .upDateLocation(new InventoryLocation());
        assertEquals("<200 OK OK,new Location{ /id= 123/name= null/createdBy= null/},[]>",
                actualUpDateLocationResult.toString());
        assertEquals(HttpStatus.OK, actualUpDateLocationResult.getStatusCode());
        assertTrue(actualUpDateLocationResult.hasBody());
        verify(inventoryLocationRepo).save((InventoryLocation) any());
    }

    @Test
    public void testDeleteLocation() {
        InventoryLocationRepo inventoryLocationRepo = mock(InventoryLocationRepo.class);
        doNothing().when(inventoryLocationRepo).deleteById((Long) any());
        ResponseEntity<?> actualDeleteLocationResult = (new LocationController(new InventoryService(inventoryLocationRepo)))
                .deleteLocation(123L);
        assertEquals("<200 OK OK,location deleted,[]>", actualDeleteLocationResult.toString());
        assertTrue(actualDeleteLocationResult.hasBody());
        assertEquals(HttpStatus.OK, actualDeleteLocationResult.getStatusCode());
        verify(inventoryLocationRepo).deleteById((Long) any());
    }
}

