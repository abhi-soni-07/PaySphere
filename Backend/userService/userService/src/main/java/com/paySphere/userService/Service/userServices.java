package com.paySphere.userService.Service;

import com.paySphere.userService.Entity.users;
import com.paySphere.userService.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class userServices {

    @Autowired
    private userRepository userRepo;

    public void saveEntry(users userEntry){
        userRepo.save(userEntry);
    }

    public List<users> getAll(){
        return userRepo.findAll();
    }

    public Optional<users> findById(long id){
        return userRepo.findById(id);
    }

    public void deleteById(long id){
        userRepo.deleteById(id);
    }
}
