package com.paySphere.userService.Controller;

import com.paySphere.userService.UserDetails.userContent;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class contentController {

    private Map<Long, userContent> userInfo=new HashMap<>();

    @GetMapping
    public List<userContent> getAll(){
        return new ArrayList<>(userInfo.values());
    }
    //User Creation
    @PostMapping("/register")
    public boolean userRegister(@RequestBody userContent register){
        userInfo.put(register.getId(),register);
        return true;
    }
    //User Login
    @PostMapping("/login")
    public boolean userLogin(@RequestBody userContent login){
        userInfo.put(login.getId(),login);
        return true;
    }
    //Fetching specific user
    @GetMapping("/id/{myProfile}")
    public userContent getProfileById(@PathVariable long myProfile){
        return userInfo.get(myProfile);
    }
    //Update user details(except id)
    @PutMapping("/update/{id}")
    public userContent updateProfile(@PathVariable long id,@RequestBody userContent user){
        return userInfo.put(id,user);
    }

}
