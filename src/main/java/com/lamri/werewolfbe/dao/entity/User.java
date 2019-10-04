package com.lamri.werewolfbe.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name="user_generator", sequenceName = "user_seq", allocationSize=1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id ;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt;

    @Column(name = "modified_at")
    @LastModifiedDate
    private Date modifiedAt;
}
