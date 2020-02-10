package com.isp.core.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table
@Data
@NoArgsConstructor
@Getter
@Setter
public class Classe extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String label;

    @Column
    String nomComplet ;

    @OneToMany(cascade=CascadeType.ALL)
    private Set<User> users = new HashSet<>();

    @OneToMany(cascade=CascadeType.ALL)
    private Set<Matiere> matiere = new HashSet<>();

    public Classe(String label , String nomComplet){
        super();
        this.label = label;
        this.nomComplet = nomComplet;
    }
}
