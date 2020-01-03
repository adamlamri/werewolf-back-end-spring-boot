package com.lamri.werewolfbe.service.address_support.province;

import com.lamri.werewolfbe.dao.entity.Province;
import com.lamri.werewolfbe.dao.repository.ProvinceRepository;
import com.lamri.werewolfbe.dto.ProvinceDTO;
import com.lamri.werewolfbe.mapper.ProvinceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceRepository provinceRepository;

    @Autowired
    ProvinceMapper provinceMapper;

    @Override
    public List<ProvinceDTO> getAllProvinces() {
        List<Province> provinces = provinceRepository.findAllByActiveIsTrue();

        List<ProvinceDTO> provinceDTOS = provinceMapper.provincesToProvinceDTOS(provinces);
        return provinceDTOS;
    }
}
