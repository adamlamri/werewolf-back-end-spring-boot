//package com.lamri.werewolfbe.utils;
//
//import com.lamri.werewolfbe.dao.entity.District;
//import com.lamri.werewolfbe.dao.entity.Province;
//import com.lamri.werewolfbe.dao.entity.Village;
//import com.lamri.werewolfbe.dao.entity.Ward;
//import com.lamri.werewolfbe.dao.entity.company.CompanyAddress;
//import com.lamri.werewolfbe.dao.repository.DistrictRepository;
//import com.lamri.werewolfbe.dao.repository.ProvinceRepository;
//import com.lamri.werewolfbe.dao.repository.VillageRepository;
//import com.lamri.werewolfbe.dao.repository.WardRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class AddressSupportUtils {
//
//    @Autowired
//    private ProvinceRepository provinceRepository;
//    @Autowired
//    private DistrictRepository districtRepository;
//    @Autowired
//    private WardRepository wardRepository;
//    @Autowired
//    private VillageRepository villageRepository;
//
//    public static CompanyAddress createCompanyAddress(String provinceId, String districtId, String wardId, String villageId, String detail) {
//        Province province = provinceRepository.findByProvinceId(companyDTO.getProvinceId());
//        District district = districtRepository.findByDistrictId(companyDTO.getDistrictId());
//        Ward ward = wardRepository.findByWardId(companyDTO.getWardId());
//        Village village = villageRepository.findByVillageId(companyDTO.getVillageId());
//    }
//
//}
