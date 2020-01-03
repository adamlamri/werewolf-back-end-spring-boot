package com.lamri.werewolfbe.service.address_support.ward;

import com.lamri.werewolfbe.dao.entity.Ward;
import com.lamri.werewolfbe.dto.WardDTO;

import java.util.List;

public interface WardService {

    List<WardDTO> getAllWardsByDistrictId(String districtId);

}
