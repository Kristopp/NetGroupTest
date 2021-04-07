package com.example.NetGroup.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ItemTest {
    @Test
    public void testConstructor() {
        Item actualItem = new Item( "https://example.org/example", "Name", 12334123L,"Location", 1,
                "The characteristics of someone or something");
        assertEquals(1, actualItem.quantity.intValue());
        assertEquals("Location", actualItem.location);
        assertEquals("https://example.org/example", actualItem.img_url);
        assertEquals("The characteristics of someone or something", actualItem.description);
        assertEquals("Name", actualItem.getName());
        System.out.println(actualItem);
    }
}

