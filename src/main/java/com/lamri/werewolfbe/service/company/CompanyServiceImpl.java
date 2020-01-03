package com.lamri.werewolfbe.service.company;

import com.lamri.werewolfbe.dao.entity.Country;
import com.lamri.werewolfbe.dao.entity.District;
import com.lamri.werewolfbe.dao.entity.Province;
import com.lamri.werewolfbe.dao.entity.Village;
import com.lamri.werewolfbe.dao.entity.Ward;
import com.lamri.werewolfbe.dao.entity.company.Company;
import com.lamri.werewolfbe.dao.entity.company.CompanyAddress;
import com.lamri.werewolfbe.dao.repository.company.CompanyRepository;
import com.lamri.werewolfbe.dao.repository.DistrictRepository;
import com.lamri.werewolfbe.dao.repository.ProvinceRepository;
import com.lamri.werewolfbe.dao.repository.VillageRepository;
import com.lamri.werewolfbe.dao.repository.WardRepository;
import com.lamri.werewolfbe.dao.repository.country.CountryRepository;
import com.lamri.werewolfbe.dto.company.CompanyAddressDTO;
import com.lamri.werewolfbe.dto.company.CompanyDTO;
import com.lamri.werewolfbe.dto.company.CreateCompanyDTO;
import com.lamri.werewolfbe.mapper.company.CompanyAddressMapper;
import com.lamri.werewolfbe.mapper.company.CompanyMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    ProvinceRepository provinceRepository;
    @Autowired
    DistrictRepository districtRepository;
    @Autowired
    WardRepository wardRepository;
    @Autowired
    VillageRepository villageRepository;

    @Autowired
    CompanyMapper companyMapper;
    @Autowired
    CompanyAddressMapper companyAddressMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CompanyDTO> findAllCompaniesByUserId(long userId) {
        List<Company> companies = companyRepository.findAllByUserIdAndDeletedIsFalse(userId);
        List<CompanyDTO> companyDTOS = companyMapper.companyToCompanyDTOs(companies);

        return companyDTOS;
    }

    public CompanyDTO createCompany(CreateCompanyDTO companyDTO, long userId) {
        Country country = countryRepository.findByIso(companyDTO.getCountryIso());

        Province province = provinceRepository.findByProvinceId(companyDTO.getProvinceId());
        District district = districtRepository.findByDistrictId(companyDTO.getDistrictId());
        Ward ward = wardRepository.findByWardId(companyDTO.getWardId());
        Village village = villageRepository.findByVillageId(companyDTO.getVillageId());

        Company company = new Company();
        company.setCompanyId(null);
        company.setUserId(userId);
        company.setActive(true);
        company.setDeleted(false);
        company.setCountry(country);
        company.setEmail(companyDTO.getEmail());
        company.setName(companyDTO.getName());


        CompanyAddress companyAddress = new CompanyAddress();
        companyAddress.setProvince(province);
        companyAddress.setDistrict(district);
        companyAddress.setWard(ward);
        companyAddress.setVillage(village);
        companyAddress.setDeleted(false);
        companyAddress.setActive(true);

        company.addCompanyAddress(companyAddress);

        Company newCompany = companyRepository.save(company);

        log.info("Company: " + newCompany + " saved to userId:" + userId);

        return companyMapper.companyToCompanyDTO(newCompany);
    }

}
