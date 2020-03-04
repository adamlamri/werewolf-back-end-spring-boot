package com.lamri.werewolfbe.service.company;

import com.lamri.werewolfbe.dao.entity.Country;
import com.lamri.werewolfbe.dao.entity.District;
import com.lamri.werewolfbe.dao.entity.Province;
import com.lamri.werewolfbe.dao.entity.Village;
import com.lamri.werewolfbe.dao.entity.Ward;
import com.lamri.werewolfbe.dao.entity.company.Company;
import com.lamri.werewolfbe.dao.entity.company.CompanyAddress;
import com.lamri.werewolfbe.dao.entity.user.User;
import com.lamri.werewolfbe.dao.repository.company.CompanyRepository;
import com.lamri.werewolfbe.dao.repository.DistrictRepository;
import com.lamri.werewolfbe.dao.repository.ProvinceRepository;
import com.lamri.werewolfbe.dao.repository.VillageRepository;
import com.lamri.werewolfbe.dao.repository.WardRepository;
import com.lamri.werewolfbe.dao.repository.country.CountryRepository;
import com.lamri.werewolfbe.dao.repository.user.UserRepository;
import com.lamri.werewolfbe.dto.company.CompanyAddressDTO;
import com.lamri.werewolfbe.dto.company.CompanyDTO;
import com.lamri.werewolfbe.dto.company.CreateCompanyDTO;
import com.lamri.werewolfbe.mapper.company.CompanyAddressMapper;
import com.lamri.werewolfbe.mapper.company.CompanyMapper;
import com.lamri.werewolfbe.utils.Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
public class CompanyServiceImpl implements CompanyService {

    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private WardRepository wardRepository;
    @Autowired
    private VillageRepository villageRepository;

    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private CompanyAddressMapper companyAddressMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CompanyDTO> findAllCompaniesByUser(User user) {
        List<Company> companies = companyRepository.findAllByUserAndDeletedIsFalse(user);
        List<CompanyDTO> companyDTOS = companyMapper.companyToCompanyDTOs(companies);

        return companyDTOS;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompanyDTO> findAllCompaniesOfCurrentUser() {
        final User currentUser = Utils.getCurrentUser();

        return findAllCompaniesByUser(currentUser);
    }

    @Transactional
    @Override
    public CompanyDTO createCompany(CreateCompanyDTO companyDTO) {

        User currentUser = userRepository.getOne(Utils.getCurrentUser().getUserId());

        Country country = countryRepository.findByIso(companyDTO.getCountryIso());

        Province province = provinceRepository.findByProvinceId(companyDTO.getProvinceId());
        District district = districtRepository.findByDistrictId(companyDTO.getDistrictId());
        Ward ward = wardRepository.findByWardId(companyDTO.getWardId());
        Village village = villageRepository.findByVillageId(companyDTO.getVillageId());

        Company company = new Company();
        company.setCompanyId(null);
        company.setActive(true);
        company.setDeleted(false);
        company.setCountry(country);
        company.setEmail(companyDTO.getEmail());
        company.setName(companyDTO.getName());
        company.setUser(currentUser);

        CompanyAddress companyAddress = new CompanyAddress();
        companyAddress.setProvince(province);
        companyAddress.setDistrict(district);
        companyAddress.setWard(ward);
        companyAddress.setVillage(village);
        companyAddress.setDeleted(false);
        companyAddress.setActive(true);

        company.addCompanyAddress(companyAddress);

        Company newCompany = companyRepository.save(company);

        log.info("Company: " + newCompany + " saved to userId:" + currentUser.getUserId());

        return companyMapper.companyToCompanyDTO(newCompany);
    }

}
