package com.lamri.werewolfbe.dao.entity.user;

import com.lamri.werewolfbe.dao.entity.Technology;
import com.lamri.werewolfbe.dao.entity.candidate.Candidate;
import com.lamri.werewolfbe.dao.entity.company.Company;
import lombok.Data;
import org.hibernate.Hibernate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User implements UserDetails, Serializable {

    private static final long serialVersionUID = 7866545119065747212L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_seq", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Company> companies = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Candidate> candidates = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Technology> technologies = new ArrayList<>();

    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt;

    @Column(name = "modified_at")
    @LastModifiedDate
    private Date modifiedAt;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked = true;

    private boolean enabled = true;

    private boolean credentialsNonExpired = true;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        this.roles.forEach(role -> {
            String name = role.authority;
            grantedAuthorityList.add(new SimpleGrantedAuthority(name));
        });
        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public void addCompany(Company company) {
        if (company != null) {
            this.getCompanies().add(company);
            company.setUser(this);
        }
    }

    public void addCandidate(Candidate candidate) {
        if (candidate != null) {
            this.getCandidates().add(candidate);
            candidate.setUser(this);
        }
    }

    public void addTechnology(Technology technology) {
        if (technology != null) {
            this.getTechnologies().add(technology);
            technology.setUser(this);
        }
    }
}
