package com.example.NetGroup.service;


import com.example.NetGroup.model.User;
import com.example.NetGroup.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class UserService {
    //Service methods for Crud(create read update delete);
    private final UserRepository usersRepo;

    //Takes user  data;
    @Autowired
    public UserService(UserRepository usersRepo) {
        //create new instance
        this.usersRepo = usersRepo;
    }


    public User createNewUser(@RequestBody User user) {
        LocalDateTime createdAt = LocalDateTime.now();
        user.setCreatedAt(createdAt);
        System.out.println("new User created" + user);
        return usersRepo.save(user);
    }

    //Get list of all Users
    public List<User> findAllUsers() {
        return usersRepo.findAll();
    }

    //Update user
    public User updateUser(User users) {
        return usersRepo.save(users);
    }

    //Find user by id
    public User findUsersById(Long id) throws UserPrincipalNotFoundException {
        return usersRepo.findById(id).orElseThrow(() ->
                new UserPrincipalNotFoundException("User by id" + id + "Was not found"));
    }

    //delete User
    public void deleteUser(Long id) {
        usersRepo.deleteById(id);
    }

}
