package com.lamri.werewolfbe.controller;

import com.lamri.werewolfbe.dto.UserDTO;
import com.lamri.werewolfbe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    //SERVICE
    @Autowired
    private UserService userService;


    @GetMapping("/all")
    public ResponseEntity<Object> getAllUsers() {
        Optional<List<UserDTO>> userDTOsOptional = Optional.ofNullable(userService.listAllUser());
        return userDTOsOptional.<ResponseEntity<Object>>map(
                userDTOS -> new ResponseEntity<>(userDTOS, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("No user exits", HttpStatus.OK));
    }
}
