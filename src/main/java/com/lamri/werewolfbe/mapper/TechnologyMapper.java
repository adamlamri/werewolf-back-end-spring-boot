package com.lamri.werewolfbe.mapper;

import com.lamri.werewolfbe.dao.entity.Technology;
import com.lamri.werewolfbe.dto.TechnologyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Mapper
public class TechnologyMapper {

    public String technologyToTechnologyName(Technology technology) {
        if (technology == null) {
            return null;
        }
        return technology.getName();
    }

    public List<String> technologiesToTechnologyNames(List<Technology> technologies) {
        List<String> names = new ArrayList<>();
        if (!CollectionUtils.isEmpty(technologies)) {
            technologies.forEach(technology -> names.add(technology.getName()));
        }
        return names;
    }
}
