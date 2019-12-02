package com.lamri.werewolfbe.dto.company;

import com.lamri.werewolfbe.dto.CountryDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class CompanyDTO implements Serializable {

    private Long companyId;

    private Long userId;

    private CountryDTO country;

    private String name;

    private Date createdAt;

    private Date modifiedAt;

    private String email;

    private List<CompanyAddressDTO> companyAddresses;

}
