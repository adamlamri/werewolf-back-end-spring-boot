package com.lamri.werewolfbe.mapper;

import com.lamri.werewolfbe.dao.entity.District;
import com.lamri.werewolfbe.dao.entity.Province;
import com.lamri.werewolfbe.dto.DistrictDTO;
import com.lamri.werewolfbe.dto.ProvinceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DistrictMapper {
    DistrictMapper INSTANCE = Mappers.getMapper(DistrictMapper.class);

    District districtDTOToDistrict(DistrictDTO districtDTO);

    DistrictDTO districtToDistrictDTO(District district);

    List<District> districtDTOSToProvinces(List<DistrictDTO> districtDTOS);

    List<DistrictDTO> districtsToDistrictDTOS(List<District> districts);
}
