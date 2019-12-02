package com.lamri.werewolfbe.mapper.company;

import com.lamri.werewolfbe.dao.entity.company.CompanyAddress;
import com.lamri.werewolfbe.dto.company.CompanyAddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CompanyAddressMapper {

    CompanyAddressMapper INSTANCE = Mappers.getMapper(CompanyAddressMapper.class);

    CompanyAddress companyAddressDTOToCompanyAddress(CompanyAddressDTO companyAddressDTO);

    CompanyAddressDTO companyAddressToCompanyAddressDTO(CompanyAddress companyAddress);

    List<CompanyAddress> companyAddressDTOsToCompanyAddresses(List<CompanyAddressDTO> companyAddressDTOS);

    List<CompanyAddressDTO> companyAddressToCompanyAddressDTO(List<CompanyAddress> companyAddresses);
}
