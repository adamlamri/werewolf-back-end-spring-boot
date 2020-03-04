package com.lamri.werewolfbe.dao.repository;

import com.lamri.werewolfbe.dao.entity.Technology;
import com.lamri.werewolfbe.dao.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Long> {

    List<Technology> findAllByActiveIsTrueAndUser(User user);

    Technology findByNameIgnoreCaseAndUser(String name, User user);
}
