package com.example.NetGroup.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class InventoryLocationTest {
    @Test
    public void testConstructor() {
        InventoryLocation actualInventoryLocation = new InventoryLocation(123L, "Name", "Jan 1, 2020 8:00am GMT+0100",
                123);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualInventoryLocation.getCreatedBy());
        assertEquals(123, actualInventoryLocation.id);
        assertEquals(123, actualInventoryLocation.getParentId().longValue());
        assertEquals("Name", actualInventoryLocation.getName());
        System.out.print(actualInventoryLocation);
    }

    @Test
    public void testGetId() {
        assertEquals(0L, (new InventoryLocation()).getId().longValue());
    }

    @Test
    public void testSetId() {
        InventoryLocation inventoryLocation = new InventoryLocation();
        inventoryLocation.setId(123L);
        assertEquals(123L, inventoryLocation.id);
    }

    @Test
    public void testSetName() {
        InventoryLocation inventoryLocation = new InventoryLocation();
        inventoryLocation.setName();
        assertNull(inventoryLocation.getName());
    }

    @Test
    public void testSetCreatedBy() {
        InventoryLocation inventoryLocation = new InventoryLocation();
        inventoryLocation.setCreatedBy();
        assertNull(inventoryLocation.getName());
    }

    @Test
    public void testGetParentId() {
        assertNull((new InventoryLocation()).getParentId());
    }

    @Test
    public void testSetParentId() {
        InventoryLocation inventoryLocation = new InventoryLocation();
        inventoryLocation.setParentId();
        assertNull(inventoryLocation.getParentId());
    }

    @Test
    public void testToString() {
        assertEquals("new Location{ n/id= 0/name= nulln/createdBy= nulln/parrentId= nulln/}",
                (new InventoryLocation()).toString());
    }
}

