package com.lamri.werewolfbe.service.address_support.district;

import com.lamri.werewolfbe.dao.entity.District;
import com.lamri.werewolfbe.dao.entity.Province;
import com.lamri.werewolfbe.dao.repository.DistrictRepository;
import com.lamri.werewolfbe.dao.repository.ProvinceRepository;
import com.lamri.werewolfbe.dto.DistrictDTO;
import com.lamri.werewolfbe.mapper.DistrictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    ProvinceRepository provinceRepository;

    @Autowired
    DistrictMapper districtMapper;

    @Override
    public List<DistrictDTO> getAllDistrictsByProvinceId(String provinceId) {
        Province province = provinceRepository.findByProvinceId(provinceId);
        List<District> districts = districtRepository.findAllByProvinceEquals(province);

        return districtMapper.districtsToDistrictDTOS(districts);
    }

}
