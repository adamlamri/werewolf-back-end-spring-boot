package com.lamri.werewolfbe.dao.entity.candidate;

import com.lamri.werewolfbe.dao.entity.District;
import com.lamri.werewolfbe.dao.entity.Province;
import com.lamri.werewolfbe.dao.entity.Village;
import com.lamri.werewolfbe.dao.entity.Ward;
import com.lamri.werewolfbe.dao.entity.company.Company;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "candidate_address")
@Where(clause = "deleted = false")
@ToString(exclude = {"candidate"})
public class CandidateAddress {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidate_address_generator")
    @SequenceGenerator(name="candidate_address_generator", sequenceName = "candidate_address_seq", allocationSize=1)
    @Column(name = "id", updatable = false, nullable = false)
    Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "candidate_address_id")
    Candidate candidate;

    String detail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id")
    Province province;

    @ManyToOne
    @JoinColumn(name = "district_id")
    District district;

    @ManyToOne
    @JoinColumn(name = "ward_id")
    Ward ward;

    @ManyToOne
    @JoinColumn(name = "village_id")
    Village village;


    @Column(columnDefinition = "boolean default true")
    Boolean active;

    @Column(columnDefinition = "boolean default false")
    Boolean deleted;
}
