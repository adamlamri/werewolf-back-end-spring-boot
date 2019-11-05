package com.lamri.werewolfbe.dao.entity.oauth;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class OauthAccessToken {
    @Id
    String tokenId;
    Byte[] token;
    String authenticationId;
    String userName;
    String clientId;
    Byte[] authentication;
    String refreshToken;
}
