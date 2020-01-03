package com.lamri.werewolfbe.service.address_support.village;

import com.lamri.werewolfbe.dao.entity.Village;
import com.lamri.werewolfbe.dao.entity.Ward;
import com.lamri.werewolfbe.dao.repository.VillageRepository;
import com.lamri.werewolfbe.dao.repository.WardRepository;
import com.lamri.werewolfbe.dto.VillageDTO;
import com.lamri.werewolfbe.mapper.VillageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VillageServiceImpl implements VillageService {

    @Autowired
    WardRepository wardRepository;

    @Autowired
    VillageRepository villageRepository;

    @Autowired
    VillageMapper villageMapper;

    @Override

    public List<VillageDTO> getAllVillagesByWardId(String wardId) {
        Ward ward = wardRepository.findByWardId(wardId);
        List<Village> villages = villageRepository.findAllByWardEquals(ward);
        return villageMapper.villagesToVillageDTOS(villages);
    }
}
