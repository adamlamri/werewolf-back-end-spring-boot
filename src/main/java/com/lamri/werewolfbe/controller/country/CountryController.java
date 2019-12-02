package com.lamri.werewolfbe.controller.country;

import com.lamri.werewolfbe.dto.CountryDTO;
import com.lamri.werewolfbe.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(CountryController.BASE_URL)
public class CountryController {

    public static final String BASE_URL = "/api/v1/country";

    @Autowired
    CountryService countryService;

    @GetMapping("/all")
    public ResponseEntity<Object> getAllActiveCountries() {

        Optional<List<CountryDTO>> countryDTOS = Optional.ofNullable(countryService.findAllActiveCountries());
        return countryDTOS.<ResponseEntity<Object>>map(
                userDTOS -> new ResponseEntity<>(userDTOS, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("No countries exit", HttpStatus.OK));
    }
}
