package com.lamri.werewolfbe.utils;

import com.lamri.werewolfbe.dao.entity.user.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Log4j2
public class Utils {

    public static User getCurrentUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final User currentUser = (User) authentication.getPrincipal();
        log.info("Current user: " + currentUser.getUsername());
        return currentUser;
    }

}
