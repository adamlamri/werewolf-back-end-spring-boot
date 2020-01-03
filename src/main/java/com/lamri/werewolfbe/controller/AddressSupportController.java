package com.lamri.werewolfbe.controller;

import com.lamri.werewolfbe.dto.DistrictDTO;
import com.lamri.werewolfbe.dto.ProvinceDTO;
import com.lamri.werewolfbe.dto.VillageDTO;
import com.lamri.werewolfbe.dto.WardDTO;
import com.lamri.werewolfbe.service.address_support.district.DistrictService;
import com.lamri.werewolfbe.service.address_support.province.ProvinceService;
import com.lamri.werewolfbe.service.address_support.village.VillageService;
import com.lamri.werewolfbe.service.address_support.ward.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AddressSupportController.BASE_URL)
public class AddressSupportController {

    public static final String BASE_URL = "/api/v1/addressSupport";

    @Autowired
    ProvinceService provinceService;
    @Autowired
    DistrictService districtService;
    @Autowired
    WardService wardService;
    @Autowired
    VillageService villageService;

    @GetMapping("/provinces")
    public ResponseEntity<Object> getAllActiveProvinces() {

        Optional<List<ProvinceDTO>> optionalProvinceDTOS = Optional.ofNullable(provinceService.getAllProvinces());
        return optionalProvinceDTOS.<ResponseEntity<Object>>map(
                provinceDTOS -> new ResponseEntity<>(provinceDTOS, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("No provinces exit", HttpStatus.OK));
    }

    @GetMapping("/districtsByProvince")
    public ResponseEntity<Object> getAllDistrictsByIdProvince(@RequestParam String provinceId) {

        Optional<List<DistrictDTO>> optionalDistrictDTOS = Optional.ofNullable(districtService.getAllDistrictsByProvinceId(provinceId));
        return optionalDistrictDTOS.<ResponseEntity<Object>>map(
                districtDTOS -> new ResponseEntity<>(districtDTOS, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("No districts exit", HttpStatus.OK));
    }

    @GetMapping("/wardsByDistrict")
    public ResponseEntity<Object> getAllWardsByDistrict(@RequestParam String districtId) {

        Optional<List<WardDTO>> optionalDistrictDTOS = Optional.ofNullable(wardService.getAllWardsByDistrictId(districtId));
        return optionalDistrictDTOS.<ResponseEntity<Object>>map(
                wardDTOS -> new ResponseEntity<>(wardDTOS, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("No wards exit", HttpStatus.OK));
    }

    @GetMapping("/villagesByWard")
    public ResponseEntity<Object> getAllVillagesByWard(@RequestParam String wardId) {

        Optional<List<VillageDTO>> optionalVillageDTOS = Optional.ofNullable(villageService.getAllVillagesByWardId(wardId));
        return optionalVillageDTOS.<ResponseEntity<Object>>map(
                villageDTOS -> new ResponseEntity<>(villageDTOS, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("No villages exit", HttpStatus.OK));
    }
}
