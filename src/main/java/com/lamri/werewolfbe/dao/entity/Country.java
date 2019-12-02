package com.lamri.werewolfbe.dao.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
@ToString
public class Country implements Serializable {

    @Id
    @Column(name = "iso", updatable = false, nullable = false)
    String iso;
    String name;
    String niceName;
    String iso3;
    Integer numCode;
    Integer phoneCode;
    Boolean active;
}
