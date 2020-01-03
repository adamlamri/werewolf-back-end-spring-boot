package com.lamri.werewolfbe.service.address_support.ward;

import com.lamri.werewolfbe.dao.entity.District;
import com.lamri.werewolfbe.dao.entity.Ward;
import com.lamri.werewolfbe.dao.repository.DistrictRepository;
import com.lamri.werewolfbe.dao.repository.WardRepository;
import com.lamri.werewolfbe.dto.WardDTO;
import com.lamri.werewolfbe.mapper.WardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardServiceImpl implements WardService {

    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    WardRepository wardRepository;

    @Autowired
    WardMapper wardMapper;

    @Override
    public List<WardDTO> getAllWardsByDistrictId(String districtId) {
        District district = districtRepository.findByDistrictId(districtId);
        List<Ward> wards = wardRepository.findAllByDistrictEquals(district);
        return wardMapper.wardsToWardDTOS(wards);
    }
}
