package com.lamri.werewolfbe.mapper;

import com.lamri.werewolfbe.dao.entity.Province;
import com.lamri.werewolfbe.dto.ProvinceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProvinceMapper {
    ProvinceMapper INSTANCE = Mappers.getMapper(ProvinceMapper.class);

    Province provinceDTOToProvince(ProvinceDTO provinceDTO);

    ProvinceDTO provinceToProvinceDTO(Province province);

    List<Province> provinceDTOSToProvinces(List<ProvinceDTO> provinceDTOS);

    List<ProvinceDTO> provincesToProvinceDTOS(List<Province> provinces);
}
