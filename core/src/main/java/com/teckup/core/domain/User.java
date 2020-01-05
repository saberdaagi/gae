package com.teckup.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teckup.core.constants.Role;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
    name = "users",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = { "username" }),
        @UniqueConstraint(columnNames = { "email" })
    },
        schema = "gae"
)
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotEmpty
    String username;

    @Email
    @NotEmpty
    String email;

    @JsonIgnore
    @ToString.Exclude
    String password;


    @Enumerated(EnumType.STRING)
    Role role;



    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private Etudiant etudiant;

    public User(String username, String email, String password, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

}
