package com.lamri.werewolfbe.dao.entity.oauth;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class OauthClientToken {
    @Id
    String tokenId;
    Byte[] token;
    String authenticationId;
    String username;
    String clientId;
}
