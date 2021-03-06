package com.lamri.werewolfbe.controller.company;

import com.lamri.werewolfbe.dto.company.CompanyDTO;
import com.lamri.werewolfbe.dto.company.CreateCompanyDTO;
import com.lamri.werewolfbe.service.company.CompanyService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping(CompanyController.BASE_URL)
public class CompanyController {

    public static final String BASE_URL = "/api/v1/company";
    public static final String ALL_COMPANY_OF_CURRENT_USER = "/allCompaniesOfCurrentUser";

    @Autowired
    CompanyService companyService;

    @GetMapping(ALL_COMPANY_OF_CURRENT_USER)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getAllCompaniesOfCurrentUser() {
        Optional<List<CompanyDTO>> companyDTOS = Optional.ofNullable(companyService.findAllCompaniesOfCurrentUser());

        return companyDTOS.<ResponseEntity<Object>>map(
                userDTOS -> new ResponseEntity<>(companyDTOS, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("No companies exit", HttpStatus.OK));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> createNewCompany(@RequestBody CreateCompanyDTO createCompanyDTO) {
        Optional<CompanyDTO> companyDTO = Optional.ofNullable(companyService.createCompany(createCompanyDTO));

        return companyDTO.<ResponseEntity<Object>>map(
                userDTOS -> new ResponseEntity<>(companyDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("Cannot create company", HttpStatus.OK));
    }
}
