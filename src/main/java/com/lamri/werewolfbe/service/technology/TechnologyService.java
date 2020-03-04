package com.lamri.werewolfbe.service.technology;

import com.lamri.werewolfbe.dao.entity.Technology;

import java.util.List;

public interface TechnologyService {

    List<String> findAllByCurrentUserAndActiveIsTrue();

    List<Technology> saveOrUpdateTechnologies(List<String> technologyNames);

}
