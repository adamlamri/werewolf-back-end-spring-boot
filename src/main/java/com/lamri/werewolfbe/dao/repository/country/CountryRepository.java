package com.lamri.werewolfbe.dao.repository.country;

import com.lamri.werewolfbe.dao.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    List<Country> findAllByActiveIsTrue();

}
