package com.kodilla.medicalclinic.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private long id;
    @Column(name = "FIRST_NAME")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    private String login;
    private String password;
    @OneToMany(
            targetEntity = Visit.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Visit> visits;
}
