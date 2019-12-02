package com.lamri.werewolfbe.mapper;

import com.lamri.werewolfbe.dao.entity.Country;
import com.lamri.werewolfbe.dto.CountryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    Country countryDTOToCountry(CountryDTO countryDTO);
    CountryDTO countryToCountryDTO(Country country);

    List<Country> countryDTOsToCountries(List<CountryDTO> countryDTOS);
    List<CountryDTO> countriesToCountryDTO(List<Country> countries);
}
