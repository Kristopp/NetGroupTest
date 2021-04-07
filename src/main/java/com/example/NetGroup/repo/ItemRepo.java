package com.example.NetGroup.repo;


import com.example.NetGroup.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, Long> {
}
