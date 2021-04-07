package com.example.NetGroup.repo;


import com.example.NetGroup.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}