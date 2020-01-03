package com.lamri.werewolfbe.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class DistrictDTO implements Serializable {

    String districtId;
    String name;
}
