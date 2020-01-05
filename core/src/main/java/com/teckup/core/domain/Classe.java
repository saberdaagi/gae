package com.teckup.core.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(schema = "gae")
@Data
@NoArgsConstructor
public class Classe extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;



    @Column
    String label;


    @Column
    String nomComplet ;

    @OneToMany(mappedBy="classe", cascade=CascadeType.ALL)
    private Set<Etudiant> users = new HashSet<>();
}
