package com.lamri.werewolfbe.dao.entity.candidate;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Candidate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidate_generator")
    @SequenceGenerator(name="candidate_generator", sequenceName = "candidate_generator_seq", allocationSize=1)
    @Column(name = "candidate_id", updatable = false, nullable = false)
    private Long candidateId;

    private String firstName;
    private String middleName;
    private String lastName;

    private Date dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "candidate_cv_id", referencedColumnName = "candidate_cv_id")
    private CandidateCV candidateCV;

    @Column(columnDefinition = "boolean default false")
    private Boolean deleted;

}
