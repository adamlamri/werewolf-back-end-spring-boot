package com.lamri.werewolfbe.controller.company;

import com.lamri.werewolfbe.dao.entity.user.User;
import com.lamri.werewolfbe.dto.company.CompanyDTO;
import com.lamri.werewolfbe.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(CompanyController.BASE_URL)
public class CompanyController {

    public static final String BASE_URL = "/api/v1/company";

    @Autowired
    CompanyService companyService;

    @GetMapping("/allCompanyOfCurrentUser")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getAllCompaniesOfCurrentUser() {

        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final User currentUser = (User) authentication.getPrincipal();
        Optional<List<CompanyDTO>> companyDTOS = Optional.ofNullable(companyService.findAllCompaniesByUserId(currentUser.getUserId()));

        return companyDTOS.<ResponseEntity<Object>>map(
                userDTOS -> new ResponseEntity<>(companyDTOS, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("No companies exit", HttpStatus.OK));
    }
}
