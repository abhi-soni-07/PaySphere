package com.paySphere.userService.Controller;

import com.paySphere.userService.Entity.users;
import com.paySphere.userService.Service.userServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class userController {

    @Autowired
    private userServices userServiceEntry;

    //Display All users entry
    @GetMapping
    public List<users> getAll(){
        return userServiceEntry.getAll();
    }

    //User Creation
    @PostMapping("/register")
    public boolean userRegister(@RequestBody users register){
        register.setCreated_at(LocalDateTime.now());
        userServiceEntry.saveEntry(register);
        return true;
    }

    //User Login
    @PostMapping("/login")
    public boolean userLogin(@RequestBody users login){
        login.setCreated_at(LocalDateTime.now());
        userServiceEntry.saveEntry(login);
        return true;
    }

    //Fetching specific user
    @GetMapping("/id/{myId}")
    public users getProfileById(@PathVariable long myId){
        return userServiceEntry.findById(myId).orElse(null);
    }

    //Deletion of users
    @DeleteMapping("/id/{myId}")
    public boolean deleteProfileById(@PathVariable long myId){
        userServiceEntry.deleteById(myId);
        return true;
    }

    //Update user details(except id)
    @PutMapping("/id/{id}")
    public users updateProfile(@PathVariable long id,@RequestBody users newEntry){
        users old=userServiceEntry.findById(id).orElse(null);
        if(old!=null){
            old.setFull_name(newEntry.getFull_name() !=null && !newEntry.getFull_name().equals("") ?
                    newEntry.getFull_name() : old.getFull_name() );
            old.setPassword(newEntry.getPassword() != null && !newEntry.getPassword().equals("") ?
                    newEntry.getPassword() : old.getPassword());
        }
        userServiceEntry.saveEntry(old);
        return old;
    }

}
