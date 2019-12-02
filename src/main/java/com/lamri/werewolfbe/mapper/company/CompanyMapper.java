package com.lamri.werewolfbe.mapper.company;

import com.lamri.werewolfbe.dao.entity.company.Company;
import com.lamri.werewolfbe.dto.company.CompanyDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CompanyMapper {

    Company companyDTOToCompany(CompanyDTO companyDTO);

    CompanyDTO companyToCompanyDTO(Company company);

    List<Company> companyDTOsToCompanies(List<CompanyDTO> companyDTOS);

    List<CompanyDTO> companyToCompanyDTOs(List<Company> companies);
}
