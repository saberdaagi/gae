package com.teck.up.gae.controller;

import com.teck.up.gae.core.model.User;
import com.teck.up.gae.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class SpringController {


    @Autowired
    private UserRepository userRepository ;

    @GetMapping
    public ResponseEntity<User> getUser(){
       User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return  new ResponseEntity<User>(user, HttpStatus.OK);
    }


    @GetMapping("/:matricule")
    public Optional<User> getUserByID(@PathVariable String matricule ){
        return userRepository.findUserWithMatricule(matricule);
    }

    @GetMapping("/all")
    public List<User> getAllUser(){
       return userRepository.findAll();
    }


    @PostMapping
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        return userRepository.setUserInfoByMatricule(user.getEmail(), user.getUsername(),user.getPrenom() ,user.getDate_nai() ,user.getMatricule());
    }

    @DeleteMapping("/:matricule")
    public void deleteUser(@PathVariable String matricule){
        Optional<User> user = userRepository.findUserWithMatricule(matricule);
       // return userRepository.delete(user);

    }


}
