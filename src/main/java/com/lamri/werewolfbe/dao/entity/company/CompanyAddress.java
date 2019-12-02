package com.lamri.werewolfbe.dao.entity.company;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "company_address")
@Where(clause = "deleted = false")
public class CompanyAddress {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_generator")
    @SequenceGenerator(name="address_generator", sequenceName = "address_seq", allocationSize=1)
    @Column(name = "id", updatable = false, nullable = false)
    Long id;

    String detail;
    String city;
    String district;

    @ManyToOne
    @JoinColumn(name = "company_id")
    Company company;

    @Column(columnDefinition = "boolean default false")
    Boolean active;

    @Column(columnDefinition = "boolean default false")
    Boolean deleted;
}
