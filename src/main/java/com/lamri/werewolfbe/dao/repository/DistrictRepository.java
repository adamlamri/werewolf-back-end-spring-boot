package com.lamri.werewolfbe.dao.repository;

import com.lamri.werewolfbe.dao.entity.District;
import com.lamri.werewolfbe.dao.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, String> {

    List<District> findAllByProvinceEquals(Province province);

    District findByDistrictId(String districtId);

}
