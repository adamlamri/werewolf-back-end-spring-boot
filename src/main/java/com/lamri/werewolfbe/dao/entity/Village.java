package com.lamri.werewolfbe.dao.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "village")
@Data
@NoArgsConstructor
@ToString(exclude = {"ward"})
public class Village implements Serializable {

    @Id
    @Column(name = "village_id", updatable = false, nullable = false)
    String villageId;
    String name;

    @ManyToOne
    @JoinColumn(name = "ward_id")
    Ward ward;

}
