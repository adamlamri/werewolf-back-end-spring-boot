package com.lamri.werewolfbe.mapper;

import com.lamri.werewolfbe.dao.entity.user.User;
import com.lamri.werewolfbe.dto.user.UserDTO;
import com.lamri.werewolfbe.dto.user.UserSignUpDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    //user <-> userDTO
    @Mapping(source = "userName", target = "userName")
    User userDTOToUser(UserDTO userDTO);

    @Mapping(source = "username", target = "userName")
    UserDTO userToUserDTO(User user);

    List<User> userDTOsToUsers(List<UserDTO> userDTOS);

    List<UserDTO> usersToUserDTOs(List<User> users);

    //user <-> userSignUpDTO
    @Mapping(source = "userName", target = "userName")
    User userSignUpDTOToUser(UserSignUpDTO userSignUpDTO);

    @Mapping(source = "username", target = "userName")
    UserSignUpDTO userToUserSignUpDTO(User user);

    List<User> userSignUpDTOsToUsers(List<UserDTO> userDTOS);

    List<UserSignUpDTO> usersToUserSignUpDTOs(List<User> users);
}
