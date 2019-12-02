package com.lamri.werewolfbe.service.company;

import com.lamri.werewolfbe.dao.entity.company.Company;
import com.lamri.werewolfbe.dao.repository.company.CompanyRepository;
import com.lamri.werewolfbe.dto.company.CompanyDTO;
import com.lamri.werewolfbe.mapper.company.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CompanyMapper companyMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CompanyDTO> findAllCompaniesByUserId(long userId) {
        List<Company> companies = companyRepository.findAllByUserIdAndDeletedIsFalse(userId);
//        removeDeletedCompanyAddresses(companies);
        return companyMapper.companyToCompanyDTOs(companies);
    }

    public CompanyDTO createCompany(CompanyDTO companyDTO) {
        Company company = companyMapper.companyDTOToCompany(companyDTO);
        Company newCompany = companyRepository.save(company);

        return companyMapper.companyToCompanyDTO(newCompany);
    }

    //USE ONLY IN READONLY method
    private void removeDeletedCompanyAddresses(List<Company> companies) {
        if (!CollectionUtils.isEmpty(companies)) {
            companies.forEach(company -> {
                if (!CollectionUtils.isEmpty(company.getCompanyAddresses())) {
                    company.getCompanyAddresses().clear();
                    company.getCompanyAddresses().addAll(company.getCompanyAddresses().stream()
                            .filter(companyAddress -> !companyAddress.getDeleted())
                    .collect(Collectors.toList()));
                }
            });
        }
    }
}
