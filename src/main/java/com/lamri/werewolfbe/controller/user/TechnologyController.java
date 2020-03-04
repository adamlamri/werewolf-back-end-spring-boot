package com.lamri.werewolfbe.controller.user;

import com.lamri.werewolfbe.dto.user.UserDTO;
import com.lamri.werewolfbe.service.technology.TechnologyService;
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
@RequestMapping(TechnologyController.BASE_URL)
public class TechnologyController {

    public static final String BASE_URL = "/api/v1/technology";
    public static final String ALL_TECHNOLOGIES_OF_CURRENT_USER = "/allTechnologiesOfCurrentUser";
    //SERVICE
    @Autowired
    private TechnologyService technologyService;



    @GetMapping(ALL_TECHNOLOGIES_OF_CURRENT_USER)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getAllTechnologiesOfCurrentUser() {

        Optional<List<String>> technologyNames = Optional.ofNullable(technologyService.findAllByCurrentUserAndActiveIsTrue());

        return technologyNames.<ResponseEntity<Object>>map(
                userDTOS -> new ResponseEntity<>(technologyNames, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("No companies exit", HttpStatus.OK));
    }
}
