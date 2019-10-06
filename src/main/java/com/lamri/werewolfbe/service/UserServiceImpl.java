package com.lamri.werewolfbe.service;

import com.lamri.werewolfbe.dao.entity.User;
import com.lamri.werewolfbe.dao.repository.UserRepository;
import com.lamri.werewolfbe.dto.UserDTO;
import com.lamri.werewolfbe.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //REPOSITORY
    @Autowired
    private UserRepository userRepository;

    //MAPPER
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDTO> listAllUser() {

            List<User> userList = userRepository.findAll();

            return userMapper.usersToUserDTOs(userList);
    }
}
