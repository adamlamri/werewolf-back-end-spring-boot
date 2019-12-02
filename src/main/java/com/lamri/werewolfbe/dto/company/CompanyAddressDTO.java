package com.lamri.werewolfbe.dto.company;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyAddressDTO {
    Long id;
    String detail;
    String city;
    String district;
    Boolean active;
}
