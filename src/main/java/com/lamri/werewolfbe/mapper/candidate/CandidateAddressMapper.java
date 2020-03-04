package com.lamri.werewolfbe.mapper.candidate;

import com.lamri.werewolfbe.dao.entity.candidate.CandidateAddress;
import com.lamri.werewolfbe.dto.candidate.CandidateAddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CandidateAddressMapper {

    CandidateAddressMapper INSTANCE = Mappers.getMapper(CandidateAddressMapper.class);

    @Mapping(source = "provinceDTO", target = "province")
    @Mapping(source = "districtDTO", target = "district")
    @Mapping(source = "wardDTO", target = "ward")
    @Mapping(source = "villageDTO", target = "village")
    CandidateAddress candidateAddressDTOToCandidateAddress(CandidateAddressDTO candidateAddressDTO);

    @Mapping(source = "province", target = "provinceDTO")
    @Mapping(source = "district", target = "districtDTO")
    @Mapping(source = "ward", target = "wardDTO")
    @Mapping(source = "village", target = "villageDTO")
    CandidateAddressDTO candidateAddressToCandidateAddressDTO(CandidateAddress candidateAddress);

    List<CandidateAddress> candidateAddressDTOsToCandidateAddresses(List<CandidateAddressDTO> candidateAddressDTOS);

    List<CandidateAddressDTO> candidateAddressesToCandidateAddressDTOS(List<CandidateAddress> candidateAddresses);
}
