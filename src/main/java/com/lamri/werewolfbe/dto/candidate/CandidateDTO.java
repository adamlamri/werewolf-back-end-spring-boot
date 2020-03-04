package com.lamri.werewolfbe.dto.candidate;

import com.lamri.werewolfbe.dto.CountryDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class CandidateDTO {
    private Long candidateId;
    private String fullName;
    private String phoneNumber;
    private String skypeId;
    private String facebookLink;
    private String email;
    private String linkedinLink;

    private CountryDTO country;

    private CandidateAddressDTO candidateAddress;

    private List<String> technologies = new ArrayList<>();
    private Date dateOfBirth;

}
