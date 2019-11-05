package com.lamri.werewolfbe.dto.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserSignUpDTO{
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
