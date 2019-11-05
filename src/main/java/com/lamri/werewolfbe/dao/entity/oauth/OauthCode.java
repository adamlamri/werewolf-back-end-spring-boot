package com.lamri.werewolfbe.dao.entity.oauth;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class OauthCode {
    @Id
    String code;
    Byte[] authentication;
}
