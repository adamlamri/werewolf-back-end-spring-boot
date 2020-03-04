package com.lamri.werewolfbe.dto.candidate;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class CreateCandidateDTO implements Serializable {

    private String fullName;
    private String phoneNumber;
    private String skypeId;
    private String facebookLink;
    private String email;

    private List<String> technologies = new ArrayList<>();

    private String countryIso;
    private String provinceId;
    private String districtId;
    private String wardId;
    private String villageId;
    private String addressDetail;
}
