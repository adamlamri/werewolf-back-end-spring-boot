package com.lamri.werewolfbe.dto.user;

import com.lamri.werewolfbe.dao.entity.user.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class UserDTO {
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private Date createdAt;
    private List<String> roleNames = new ArrayList<>();

    public void setRoleNames(Set<Role> roles) {
        roles.forEach(role -> {
            this.roleNames.add(role.getAuthority());
        });
    }
}
