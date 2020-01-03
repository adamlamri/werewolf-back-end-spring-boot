package com.lamri.werewolfbe.mapper;

import com.lamri.werewolfbe.dao.entity.Ward;
import com.lamri.werewolfbe.dto.WardDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface WardMapper {
    WardMapper INSTANCE = Mappers.getMapper(WardMapper.class);

    Ward wardDTOToWard(WardDTO WardDTO);

    WardDTO wardToWardDTO(Ward Ward);

    List<Ward> wardDTOSToWards(List<WardDTO> wardDTOS);

    List<WardDTO> wardsToWardDTOS(List<Ward> wards);
}
