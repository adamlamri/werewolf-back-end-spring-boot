package com.lamri.werewolfbe.dao.entity.candidate;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Data
@Entity(name = "candidate_cv")
public class CandidateCV {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidate_cv_generator")
    @SequenceGenerator(name="candidate_cv_generator", sequenceName = "candidate_cv_generator_seq", allocationSize=1)
    @Column(name = "candidate_cv_id", updatable = false, nullable = false)
    private Long candidateCVId;

    @Column(columnDefinition = "boolean default false")
    private Boolean deleted;
}
