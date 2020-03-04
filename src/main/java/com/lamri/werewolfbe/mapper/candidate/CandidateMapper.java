package com.lamri.werewolfbe.mapper.candidate;

import com.lamri.werewolfbe.dao.entity.Technology;
import com.lamri.werewolfbe.dao.entity.candidate.Candidate;
import com.lamri.werewolfbe.dao.entity.candidate.CandidateAddress;
import com.lamri.werewolfbe.dto.candidate.CandidateAddressDTO;
import com.lamri.werewolfbe.dto.candidate.CandidateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = {Collections.class, Collectors.class})
public abstract class CandidateMapper {

    String technologyToTechnologyName(Technology technology) {
        return technology.getName();
    }

    public abstract List<String> technologiesToTechnologyNames(List<Technology> technologies);

    @Mapping(target = "technologies", ignore = true)
    public abstract Candidate candidateDTOToCandidate(CandidateDTO candidateDTO);

    @Mapping(target = "technologies", expression = "java(candidate.getTechnologies().stream().map(technology -> technology.getName()).collect(Collectors.toList()))")
    public abstract CandidateDTO candidateToCandidateDTO(Candidate candidate);

    public abstract List<Candidate> candidateDTOSToCandidates(List<CandidateDTO> candidateDTOS);

    public abstract List<CandidateDTO> candidatesToCandidateDTOS(List<Candidate> candidates);

    @Mapping(source = "provinceDTO", target = "province")
    @Mapping(source = "districtDTO", target = "district")
    @Mapping(source = "wardDTO", target = "ward")
    @Mapping(source = "villageDTO", target = "village")
    public abstract CandidateAddress candidateAddressDTOToCandidateAddress(CandidateAddressDTO candidateAddressDTO);

    @Mapping(source = "province", target = "provinceDTO")
    @Mapping(source = "district", target = "districtDTO")
    @Mapping(source = "ward", target = "wardDTO")
    @Mapping(source = "village", target = "villageDTO")
    public abstract CandidateAddressDTO candidateAddressToCandidateAddressDTO(CandidateAddress candidateAddress);

}
