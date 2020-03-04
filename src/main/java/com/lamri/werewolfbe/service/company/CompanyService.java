package com.lamri.werewolfbe.service.company;

import com.lamri.werewolfbe.dao.entity.user.User;
import com.lamri.werewolfbe.dto.company.CompanyDTO;
import com.lamri.werewolfbe.dto.company.CreateCompanyDTO;

import java.util.List;

public interface CompanyService {

    List<CompanyDTO> findAllCompaniesByUser(User user);

    CompanyDTO createCompany(CreateCompanyDTO newCompanyDTO);

    List<CompanyDTO> findAllCompaniesOfCurrentUser();

}
