package com.lamri.werewolfbe.controller.user;

import com.lamri.werewolfbe.dto.user.UserDTO;
import com.lamri.werewolfbe.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/api/v1/user";

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

    @GetMapping("/getCurrentUserDetail")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getCurrentUserDetail() {

        UserDTO userDTO = userService.getCurrentUser();
        //TODO: handle NPE
        return userDTO;
    }
}
