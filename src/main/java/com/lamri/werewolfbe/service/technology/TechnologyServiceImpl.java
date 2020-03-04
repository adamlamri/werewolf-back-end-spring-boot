package com.lamri.werewolfbe.service.technology;

import com.lamri.werewolfbe.dao.entity.Technology;
import com.lamri.werewolfbe.dao.entity.user.User;
import com.lamri.werewolfbe.dao.repository.TechnologyRepository;
import com.lamri.werewolfbe.dao.repository.user.UserRepository;
import com.lamri.werewolfbe.mapper.TechnologyMapper;
import com.lamri.werewolfbe.utils.Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService{

    TechnologyMapper technologyMapper;
    TechnologyRepository technologyRepository;
    UserRepository userRepository;


    public TechnologyServiceImpl(TechnologyMapper technologyMapper, TechnologyRepository technologyRepository, UserRepository userRepository) {
        this.technologyMapper = technologyMapper;
        this.technologyRepository = technologyRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<String> findAllByCurrentUserAndActiveIsTrue() {
        final User currentUser = Utils.getCurrentUser();
        List<Technology> technologies = technologyRepository.findAllByActiveIsTrueAndUser(currentUser);
        return technologyMapper.technologiesToTechnologyNames(technologies);
    }

    @Override
    @Transactional
    public List<Technology> saveOrUpdateTechnologies(List<String> technologyNames) {
        List<Technology> technologies = new ArrayList<>();

        User currentUser = userRepository.getOne(Utils.getCurrentUser().getUserId());

        if (CollectionUtils.isEmpty(technologyNames)) {
            return technologies;
        }
        technologyNames.forEach(technologyName -> {
            Technology technology = saveIfTechnologyNameNotExist(technologyName, currentUser);
            technologies.add(technology);
        });
        return technologies;
    }

    private Technology saveIfTechnologyNameNotExist(String technologyName, User user) {
        Technology technology = technologyRepository.findByNameIgnoreCaseAndUser(technologyName, user);

        if (technology == null) {
            Technology newTechnology = new Technology(technologyName, user);
            technologyRepository.save(newTechnology);
            return newTechnology;
        }
        return technology;
    }
}
