package com.teck.up.gae.core.model;

import com.teck.up.gae.core.UserRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "user" ,schema = "gae")
public class User implements Serializable , UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String matricule;

    @Column(name = "nom")
    private String username;

    @Column(name = "password")
    private String password;

    private UserRole roleUser ;

    @Column(name = "prénom")
    private String prenom ;

    @Column(name = "email")
    private String email ;

    @Column(name = "Date de naissance")
    private Date date_nai ;

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


}
