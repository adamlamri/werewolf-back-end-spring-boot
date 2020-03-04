package com.lamri.werewolfbe.service.user;

import com.lamri.werewolfbe.dao.entity.user.User;
import com.lamri.werewolfbe.dao.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class WerewolfUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findUserByUserName(userName);

        if (!optionalUser.isPresent()) {
            System.out.println("No user: " + userName);
            throw new UsernameNotFoundException(String.format("User %s does not exist!", userName));
        }

        return optionalUser.get();
    }


}
