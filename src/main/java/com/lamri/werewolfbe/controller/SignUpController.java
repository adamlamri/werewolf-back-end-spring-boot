package com.lamri.werewolfbe.controller;

import com.lamri.werewolfbe.dto.user.UserDTO;
import com.lamri.werewolfbe.dto.user.UserSignUpDTO;
import com.lamri.werewolfbe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(SignUpController.BASE_URL)
public class SignUpController {

    public static final String BASE_URL = "/api/v1/signUp";

    //SERVICE
    @Autowired
    private UserService userService;


    @PostMapping("/normal")
//    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getAllUsers(@RequestBody UserSignUpDTO userSignUpDTO) {

        userService.addUser(userSignUpDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
