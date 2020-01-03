package com.lamri.werewolfbe.dao.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "province")
@Data
@NoArgsConstructor
@ToString(exclude = {"districts"})
public class Province implements Serializable {

    @Id
    @Column(name = "province_id", updatable = false, nullable = false)
    String provinceId;
    String name;
    Boolean active;

    @OneToMany(mappedBy = "province",
            fetch = FetchType.LAZY)
    List<District> districts = new ArrayList<>();
}
