package com.lamri.werewolfbe.service.country;

import com.lamri.werewolfbe.dto.CountryDTO;

import java.util.List;

public interface CountryService {

    List<CountryDTO> findAllActiveCountries();

}
