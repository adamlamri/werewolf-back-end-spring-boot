package com.lamri.werewolfbe.dao.entity;

import com.lamri.werewolfbe.dao.entity.candidate.Candidate;
import com.lamri.werewolfbe.dao.entity.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ToString
@Data
@Entity
@Table(name = "technology")
@Where(clause = "deleted = false")
@NoArgsConstructor
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "technology_generator")
    @SequenceGenerator(name = "technology_generator", sequenceName = "technology_generator_seq", allocationSize = 1)
    @Column(name = "technology_id", updatable = false, nullable = false)
    private Long technologyId;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToMany(mappedBy = "technologies", fetch = FetchType.LAZY)
    private List<Candidate> candidates = new ArrayList<>();

    @Column(columnDefinition = "boolean default true")
    private Boolean active;

    @Column(columnDefinition = "boolean default false")
    private Boolean deleted;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date modifiedAt;

    public Technology(String name, User user) {
        this.name = name;
        user.addTechnology(this);
        active = true;
        deleted = false;
        createdAt = new Date();
        modifiedAt = new Date();
    }
}
