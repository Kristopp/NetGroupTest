package com.example.NetGroup.controllers;


import com.example.NetGroup.model.Item;
import com.example.NetGroup.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    //inject it into constructor
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    //ResponseEntity is a generic so we need to pass what kind of data we are passing in this case its a list
    //List is generic to so we have to specify a list of what
    // will response HTTP body and list of users
    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> itemList= itemService.findAllItems();
        //return
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

    //Find item by id
    @GetMapping("/find/{id}")
    public ResponseEntity<Item> getUserById(@PathVariable("id") Long id) throws UserPrincipalNotFoundException {
        Item item = itemService.findItemById(id);
        //return
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    //Add item
    //We use post request here because we are making change in database
    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        Item newItem = itemService.createNewItem(item);
        System.out.println(newItem);
        //return
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    //Delete item
    @PutMapping("/update")
    public ResponseEntity<Item> upDateItem(Item item) {
        Item updatedItem = itemService.upDateItem(item);
        //return
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }

    //Delete method wont return anything
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable("id") Long id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
