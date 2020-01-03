package com.lamri.werewolfbe.dao.repository;

import com.lamri.werewolfbe.dao.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, String> {

    List<Province> findAllByActiveIsTrue();

    Province findByProvinceId(String provinceId);

}
