package com.lamri.werewolfbe.service;

import com.lamri.werewolfbe.dto.user.UserDTO;
import com.lamri.werewolfbe.dto.user.UserSignUpDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> listAllUser();

    void addUser(UserSignUpDTO userSignUpDTO);
}
