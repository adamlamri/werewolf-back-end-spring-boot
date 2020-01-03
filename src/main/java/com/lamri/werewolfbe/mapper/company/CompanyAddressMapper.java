package com.lamri.werewolfbe.mapper.company;

import com.lamri.werewolfbe.dao.entity.company.CompanyAddress;
import com.lamri.werewolfbe.dto.company.CompanyAddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CompanyAddressMapper {

    CompanyAddressMapper INSTANCE = Mappers.getMapper(CompanyAddressMapper.class);

    @Mapping(source = "provinceDTO", target = "province")
    @Mapping(source = "districtDTO", target = "district")
    @Mapping(source = "wardDTO", target = "ward")
    @Mapping(source = "villageDTO", target = "village")
    CompanyAddress companyAddressDTOToCompanyAddress(CompanyAddressDTO companyAddressDTO);

    @Mapping(source = "province", target = "provinceDTO")
    @Mapping(source = "district", target = "districtDTO")
    @Mapping(source = "ward", target = "wardDTO")
    @Mapping(source = "village", target = "villageDTO")
    CompanyAddressDTO companyAddressToCompanyAddressDTO(CompanyAddress companyAddress);

    List<CompanyAddress> companyAddressDTOsToCompanyAddresses(List<CompanyAddressDTO> companyAddressDTOS);

    List<CompanyAddressDTO> companyAddressesToCompanyAddressDTOS(List<CompanyAddress> companyAddresses);
}
