package com.lamri.werewolfbe.dao.repository;

import com.lamri.werewolfbe.dao.entity.District;
import com.lamri.werewolfbe.dao.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WardRepository extends JpaRepository<Ward, String> {

    List<Ward> findAllByDistrictEquals(District district);

    Ward findByWardId(String wardId);
}
