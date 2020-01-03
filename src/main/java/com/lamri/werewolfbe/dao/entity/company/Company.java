package com.lamri.werewolfbe.dao.entity.company;

import com.lamri.werewolfbe.dao.entity.Country;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ToString
@Data
@Entity
@Table(name = "company")
@Where(clause = "deleted = false")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_generator")
    @SequenceGenerator(name = "company_generator", sequenceName = "company_generator_seq", allocationSize = 1)
    @Column(name = "company_id", updatable = false, nullable = false)
    private Long companyId;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_iso_code")
    private Country country;

    private String name;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date modifiedAt;

    private String email;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompanyAddress> companyAddresses = new ArrayList<>();

    @Column(columnDefinition = "boolean default true")
    private Boolean active;

    @Column(columnDefinition = "boolean default false")
    private Boolean deleted;

    public void addCompanyAddress(CompanyAddress companyAddress) {
        if (companyAddress != null) {
            this.getCompanyAddresses().add(companyAddress);
            companyAddress.setCompany(this);
        }
    }
}
