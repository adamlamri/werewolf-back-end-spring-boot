package com.lamri.werewolfbe.service.country;

import com.lamri.werewolfbe.dao.entity.Country;
import com.lamri.werewolfbe.dao.repository.country.CountryRepository;
import com.lamri.werewolfbe.dto.CountryDTO;
import com.lamri.werewolfbe.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;
    @Autowired
    CountryMapper countryMapper;


    @Override
    public List<CountryDTO> findAllActiveCountries() {
        List<Country> countries = countryRepository.findAllByActiveIsTrue();
        return countryMapper.countriesToCountryDTO(countries);
    }
}
