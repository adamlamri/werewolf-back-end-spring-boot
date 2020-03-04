package com.lamri.werewolfbe.dao.entity.candidate;

import com.lamri.werewolfbe.dao.entity.Country;
import com.lamri.werewolfbe.dao.entity.Technology;
import com.lamri.werewolfbe.dao.entity.user.User;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Candidate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidate_generator")
    @SequenceGenerator(name="candidate_generator", sequenceName = "candidate_generator_seq", allocationSize=1)
    @Column(name = "candidate_id", updatable = false, nullable = false)
    private Long candidateId;

    private String fullName;
    private String phoneNumber;
    private String skypeId;
    private String facebookLink;
    private String linkedinLink;
    private String email;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "candidate_technology",
            joinColumns = @JoinColumn(name = "candidate_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
    private List<Technology> technologies = new ArrayList<>();

    @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, optional = false)
    private CandidateAddress candidateAddress;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_iso_code")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Date dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "candidate_cv_id", referencedColumnName = "candidate_cv_id")
    private CandidateCV candidateCV;

    @Column(columnDefinition = "boolean default false")
    private Boolean deleted;

    public void setCandidateAddress(CandidateAddress candidateAddress) {
        if (candidateAddress == null) {
            if (this.candidateAddress != null) {
                this.candidateAddress.setCandidate(null);
            }
        } else {
            candidateAddress.setCandidate(this);
        }
        this.candidateAddress = candidateAddress;
    }

    public void addTechnology(Technology technology) {
        this.technologies.add(technology);
        technology.getCandidates().add(this);
    }
}
