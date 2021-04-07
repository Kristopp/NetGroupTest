package com.example.NetGroup.service;


import com.example.NetGroup.model.Item;
import com.example.NetGroup.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ItemService {
    private final ItemRepo itemRepo;

    @Autowired
    public ItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public Item createNewItem(Item item) {
        LocalDateTime createdAt = LocalDateTime.now();
        item.setId(UUID.randomUUID().toString());
        item.setWhenStored(createdAt);
        System.out.println(item);
        System.out.println("new Item created at:" + createdAt);


        return itemRepo.save(item);
    }

    //Get list of all Items
    public List<Item> findAllItems() {
        return itemRepo.findAll();
    }

    //Update items
    public Item upDateItem(Item item) {
        return itemRepo.save(item);
    }

    //Find item by id
    public Item findItemById(Long id) throws UserPrincipalNotFoundException {
        return itemRepo.findById(id).orElseThrow(() ->
                new UserPrincipalNotFoundException("User by id" + id + "Was not found"));
    }

    //delete Item
    public void deleteItem(Long id) {
        itemRepo.deleteById(id);
    }
}
