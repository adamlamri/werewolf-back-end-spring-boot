package com.lamri.werewolfbe.service.candidate;

import com.lamri.werewolfbe.dao.entity.Country;
import com.lamri.werewolfbe.dao.entity.District;
import com.lamri.werewolfbe.dao.entity.Province;
import com.lamri.werewolfbe.dao.entity.Technology;
import com.lamri.werewolfbe.dao.entity.Village;
import com.lamri.werewolfbe.dao.entity.Ward;
import com.lamri.werewolfbe.dao.entity.candidate.Candidate;
import com.lamri.werewolfbe.dao.entity.candidate.CandidateAddress;
import com.lamri.werewolfbe.dao.entity.user.User;
import com.lamri.werewolfbe.dao.repository.DistrictRepository;
import com.lamri.werewolfbe.dao.repository.ProvinceRepository;
import com.lamri.werewolfbe.dao.repository.VillageRepository;
import com.lamri.werewolfbe.dao.repository.WardRepository;
import com.lamri.werewolfbe.dao.repository.candidate.CandidateRepository;
import com.lamri.werewolfbe.dao.repository.country.CountryRepository;
import com.lamri.werewolfbe.dao.repository.user.UserRepository;
import com.lamri.werewolfbe.dto.candidate.CandidateDTO;
import com.lamri.werewolfbe.dto.candidate.CreateCandidateDTO;
import com.lamri.werewolfbe.mapper.candidate.CandidateMapper;
import com.lamri.werewolfbe.service.technology.TechnologyService;
import com.lamri.werewolfbe.utils.Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    private UserRepository userRepository;
    private TechnologyService technologyService;
    private CandidateRepository candidateRepository;
    private CandidateMapper candidateMapper;
    private CountryRepository countryRepository;
    private DistrictRepository districtRepository;
    private ProvinceRepository provinceRepository;
    private WardRepository wardRepository;
    private VillageRepository villageRepository;

    public CandidateServiceImpl(UserRepository userRepository, TechnologyService technologyService, CandidateRepository candidateRepository, CandidateMapper candidateMapper, CountryRepository countryRepository, DistrictRepository districtRepository, ProvinceRepository provinceRepository, WardRepository wardRepository, VillageRepository villageRepository) {
        this.userRepository = userRepository;
        this.technologyService = technologyService;
        this.candidateRepository = candidateRepository;
        this.candidateMapper = candidateMapper;
        this.countryRepository = countryRepository;
        this.districtRepository = districtRepository;
        this.provinceRepository = provinceRepository;
        this.wardRepository = wardRepository;
        this.villageRepository = villageRepository;
    }

    public List<CandidateDTO> findAllByUserAndDeletedIsFalse() {
        User currentUser = userRepository.getOne(Utils.getCurrentUser().getUserId());

        List<Candidate> candidates = candidateRepository.findAllByUserAndDeletedIsFalse(currentUser);

        List<CandidateDTO> candidateDTOS = candidateMapper.candidatesToCandidateDTOS(candidates);
        return candidateDTOS;
    }

    @Override
    public CandidateDTO findByCurrentUserAndCandidateIdAndDeletedIsFalse(Long candidateId) {
        if (candidateId == null) {
            return null;
        }
        User currentUser = userRepository.getOne(Utils.getCurrentUser().getUserId());

        Candidate candidate = candidateRepository.findByUserAndCandidateIdAndDeletedIsFalse(currentUser, candidateId);

        CandidateDTO candidateDTO = candidateMapper.candidateToCandidateDTO(candidate);

        return candidateDTO;
    }


    @Transactional
    @Override
    public CandidateDTO createNewCandidate(CreateCandidateDTO createCandidateDTO) {

        User currentUser = userRepository.getOne(Utils.getCurrentUser().getUserId());

        Country country = countryRepository.findByIso(createCandidateDTO.getCountryIso());

        Province province = provinceRepository.findByProvinceId(createCandidateDTO.getProvinceId());
        District district = districtRepository.findByDistrictId(createCandidateDTO.getDistrictId());
        Ward ward = wardRepository.findByWardId(createCandidateDTO.getWardId());
        Village village = villageRepository.findByVillageId(createCandidateDTO.getVillageId());

        List<String> technologyNames = createCandidateDTO.getTechnologies();
        List<Technology> technologies = technologyService.saveOrUpdateTechnologies(technologyNames);

        Candidate candidate = new Candidate();
        candidate.setDeleted(false);
        candidate.setUser(currentUser);
        candidate.setCountry(country);
        candidate.setTechnologies(technologies);
        candidate.setFullName(createCandidateDTO.getFullName());
        candidate.setEmail(createCandidateDTO.getEmail());

        CandidateAddress candidateAddress = new CandidateAddress();
        candidateAddress.setProvince(province);
        candidateAddress.setDistrict(district);
        candidateAddress.setWard(ward);
        candidateAddress.setVillage(village);
        candidateAddress.setDetail(createCandidateDTO.getAddressDetail());
        candidateAddress.setDeleted(false);
        candidateAddress.setActive(true);

        candidate.setCandidateAddress(candidateAddress);

        candidateRepository.save(candidate);
        return candidateMapper.candidateToCandidateDTO(candidate);
    }

}
