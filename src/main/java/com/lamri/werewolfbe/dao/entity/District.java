package com.lamri.werewolfbe.dao.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "district")
@Data
@NoArgsConstructor
@ToString(exclude = {"wards", "province"})
public class District implements Serializable {

    @Id
    @Column(name = "district_id", updatable = false, nullable = false)
    String districtId;
    String name;

    @ManyToOne
    @JoinColumn(name = "province_id")
    Province province;

    @OneToMany(mappedBy = "district",
            fetch = FetchType.LAZY)
    List<Ward> wards = new ArrayList<>();
}
