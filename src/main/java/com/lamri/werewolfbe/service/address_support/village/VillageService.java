package com.lamri.werewolfbe.service.address_support.village;

import com.lamri.werewolfbe.dto.VillageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VillageService {

    List<VillageDTO> getAllVillagesByWardId(String provinceId);

}
