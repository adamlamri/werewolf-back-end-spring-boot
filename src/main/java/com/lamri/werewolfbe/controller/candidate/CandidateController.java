package com.lamri.werewolfbe.controller.candidate;

import com.lamri.werewolfbe.dto.candidate.CandidateDTO;
import com.lamri.werewolfbe.dto.candidate.CreateCandidateDTO;
import com.lamri.werewolfbe.service.candidate.CandidateService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping(CandidateController.BASE_URL)
public class CandidateController {

    public static final String BASE_URL = "/api/v1/candidate";
    public static final String ALL_CANDIDATES_OF_CURRENT_USER = "/allCandidatesOfCurrentUser";
    public static final String CANDIDATE_DETAILS = "/details";

    @Autowired
    CandidateService candidateService;

    @GetMapping(ALL_CANDIDATES_OF_CURRENT_USER)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getAllCandidatesOfCurrentUser() {
        Optional<List<CandidateDTO>> candidateDTOS = Optional.ofNullable(candidateService.findAllByUserAndDeletedIsFalse());

        return candidateDTOS.<ResponseEntity<Object>>map(
                userDTOS -> new ResponseEntity<>(candidateDTOS, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("No candidates exit", HttpStatus.OK));
    }
    @GetMapping(CANDIDATE_DETAILS)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getCandidateDetails(@RequestParam Long candidateId) {
        Optional<CandidateDTO> candidateDTO = Optional.ofNullable(candidateService.findByCurrentUserAndCandidateIdAndDeletedIsFalse(candidateId));

        return candidateDTO.<ResponseEntity<Object>>map(
                userDTOS -> new ResponseEntity<>(candidateDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("No candidate exit with id = " + candidateId, HttpStatus.OK));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> createNewCompany(@RequestBody CreateCandidateDTO createCandidateDTO) {
        Optional<CandidateDTO> candidateDTO = Optional.ofNullable(candidateService.createNewCandidate(createCandidateDTO));

        return candidateDTO.<ResponseEntity<Object>>map(
                userDTOS -> new ResponseEntity<>(candidateDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("Cannot create company", HttpStatus.OK));
    }
}
