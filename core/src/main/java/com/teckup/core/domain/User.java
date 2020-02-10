package com.teckup.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teckup.core.constants.Role;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"username"}),
                @UniqueConstraint(columnNames = {"email"})
        })
@Data
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String username;

    @Email
    @NotEmpty
    String email;

    @JsonIgnore
    @ToString.Exclude
    String password;


    @Enumerated(EnumType.STRING)
    Role role;


    @Column(unique = true)
    String matricule;

    @Column(name = "firstname")
    String firstName;

    @Column(name = "lastname")
    String lastName;

    @Column
    @Temporal(TemporalType.DATE)
    Date dateNaissance;

    @Column
    String gender ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "classe_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Classe classe ;


    public User(){
        super();
    }

    public User(String username, String email, String password, Role role) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

}
