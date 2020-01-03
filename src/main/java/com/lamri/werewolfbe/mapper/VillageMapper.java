package com.lamri.werewolfbe.mapper;

import com.lamri.werewolfbe.dao.entity.Village;
import com.lamri.werewolfbe.dao.entity.Ward;
import com.lamri.werewolfbe.dto.VillageDTO;
import com.lamri.werewolfbe.dto.WardDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VillageMapper {
    VillageMapper INSTANCE = Mappers.getMapper(VillageMapper.class);

    Village villageDTOToVillage(VillageDTO villageDTO);

    WardDTO villageToVillageDTO(Ward v  );

    List<Village> villageDTOSToVillages(List<Village> villages);

    List<VillageDTO> villagesToVillageDTOS(List<Village> wards);
}
