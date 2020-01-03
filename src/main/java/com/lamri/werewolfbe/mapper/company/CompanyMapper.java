package com.lamri.werewolfbe.mapper.company;

import com.lamri.werewolfbe.dao.entity.company.Company;
import com.lamri.werewolfbe.dao.entity.company.CompanyAddress;
import com.lamri.werewolfbe.dto.company.CompanyAddressDTO;
import com.lamri.werewolfbe.dto.company.CompanyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface CompanyMapper{

    Company companyDTOToCompany(CompanyDTO companyDTO);

    CompanyDTO companyToCompanyDTO(Company company);

    List<Company> companyDTOsToCompanies(List<CompanyDTO> companyDTOS);

    List<CompanyDTO> companyToCompanyDTOs(List<Company> companies);

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
}
