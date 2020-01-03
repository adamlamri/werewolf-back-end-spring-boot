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
@Table(name = "ward")
@Data
@NoArgsConstructor
@ToString(exclude = {"villages", "district"})
public class Ward implements Serializable {

    @Id
    @Column(name = "ward_id", updatable = false, nullable = false)
    String wardId;
    String name;

    @ManyToOne
    @JoinColumn(name = "district_id")
    District district;

    @OneToMany(mappedBy = "ward",
            fetch = FetchType.LAZY)
    List<Village> villages = new ArrayList<>();
}
