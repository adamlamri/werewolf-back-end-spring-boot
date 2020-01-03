package com.lamri.werewolfbe.service.company;

import com.lamri.werewolfbe.dto.company.CompanyDTO;
import com.lamri.werewolfbe.dto.company.CreateCompanyDTO;

import java.util.List;

public interface CompanyService {

    List<CompanyDTO> findAllCompaniesByUserId(long userId);

    CompanyDTO createCompany(CreateCompanyDTO newCompanyDTO, long userId);

}
