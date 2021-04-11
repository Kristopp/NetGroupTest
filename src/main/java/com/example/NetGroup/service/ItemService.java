package com.example.NetGroup.service;


import com.example.NetGroup.model.Item;
import com.example.NetGroup.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
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
        LocalDateTime localDateTime = LocalDateTime.parse("2019-11-15T13:15:30");
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        item.setWhenStored(date);
        item.setId(UUID.randomUUID().toString());

        System.out.println(item);
        System.out.println("new Item created at:" + date);


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
