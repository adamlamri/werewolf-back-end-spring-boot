package com.lamri.werewolfbe.dto.company;

import com.lamri.werewolfbe.dto.DistrictDTO;
import com.lamri.werewolfbe.dto.ProvinceDTO;
import com.lamri.werewolfbe.dto.VillageDTO;
import com.lamri.werewolfbe.dto.WardDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class CompanyAddressDTO {
    Long id;
    ProvinceDTO provinceDTO;
    DistrictDTO districtDTO;
    WardDTO wardDTO;
    VillageDTO villageDTO;
    Boolean active;
}
