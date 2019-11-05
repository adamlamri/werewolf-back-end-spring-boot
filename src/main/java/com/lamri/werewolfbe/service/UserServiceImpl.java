package com.lamri.werewolfbe.service;

import com.lamri.werewolfbe.dao.entity.user.User;
import com.lamri.werewolfbe.dao.repository.UserRepository;
import com.lamri.werewolfbe.dto.user.UserDTO;
import com.lamri.werewolfbe.dto.user.UserSignUpDTO;
import com.lamri.werewolfbe.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    @Qualifier("encoder")
    PasswordEncoder encoder;

    @Override
    public List<UserDTO> listAllUser() {

        List<User> userList = userRepository.findAll();

        return userMapper.usersToUserDTOs(userList);
    }

    @Override
    public void addUser(UserSignUpDTO userSignUpDTO) {
        String password = userSignUpDTO.getPassword();
        String hashedPassword = encoder.encode(password);
        userSignUpDTO.setPassword(hashedPassword);
        User user = userMapper.userSignUpDTOToUser(userSignUpDTO);

        userRepository.save(user);
    }
}
