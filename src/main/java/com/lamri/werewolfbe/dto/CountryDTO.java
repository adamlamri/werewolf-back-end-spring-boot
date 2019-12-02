package com.lamri.werewolfbe.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CountryDTO implements Serializable {
    String iso;
    String name;
    String niceName;
    String iso3;
    Integer numCode;
    Integer phoneCode;
    Boolean active;
}
