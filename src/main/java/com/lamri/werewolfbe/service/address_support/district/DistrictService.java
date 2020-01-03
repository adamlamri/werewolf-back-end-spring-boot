package com.lamri.werewolfbe.service.address_support.district;

import com.lamri.werewolfbe.dto.DistrictDTO;

import java.util.List;

public interface DistrictService {

    List<DistrictDTO> getAllDistrictsByProvinceId(String provinceId);

}
