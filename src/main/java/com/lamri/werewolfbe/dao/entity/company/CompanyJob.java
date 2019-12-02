package com.lamri.werewolfbe.dao.entity.company;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Data
@Entity
public class CompanyJob {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_job_generator")
    @SequenceGenerator(name="company_job_generator", sequenceName = "company_job_generator_seq", allocationSize=1)
    @Column(name = "company_job_id", updatable = false, nullable = false)
    private Long companyJobId;

    @Column(columnDefinition = "boolean default false")
    private Boolean active;

    @Column(columnDefinition = "boolean default false")
    private Boolean deleted;
}
