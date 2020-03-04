package com.lamri.werewolfbe.service.candidate;

import com.lamri.werewolfbe.dto.candidate.CandidateDTO;
import com.lamri.werewolfbe.dto.candidate.CreateCandidateDTO;

import java.util.List;

public interface CandidateService {

    List<CandidateDTO> findAllByUserAndDeletedIsFalse();

    CandidateDTO findByCurrentUserAndCandidateIdAndDeletedIsFalse(Long candidateId);

    CandidateDTO createNewCandidate(CreateCandidateDTO createCompanyDTO);
}
