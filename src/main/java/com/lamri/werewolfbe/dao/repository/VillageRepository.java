package com.lamri.werewolfbe.dao.repository;

import com.lamri.werewolfbe.dao.entity.Village;
import com.lamri.werewolfbe.dao.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VillageRepository extends JpaRepository<Village, String> {

    List<Village> findAllByWardEquals(Ward ward);

    Village findByVillageId(String villageId);

}
