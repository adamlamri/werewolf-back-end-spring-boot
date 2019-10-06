package com.lamri.werewolfbe.mapper;

import com.lamri.werewolfbe.dao.entity.User;
import com.lamri.werewolfbe.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "userName", target = "userName")
    User userDTOToUser(UserDTO userDTO);

    @Mapping(source = "userName", target = "userName")
    UserDTO userToUserDTO(User user);

    List<User> userDTOsToUsers(List<UserDTO> userDTOS);

    List<UserDTO> usersToUserDTOs(List<User> users);
}
