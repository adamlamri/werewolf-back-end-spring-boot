package com.lamri.werewolfbe.dto.company;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateCompanyDTO {
    String name;

    String email;
    String countryIso;
    String provinceId;
    String districtId;
    String wardId;
    String villageId;

}
