package com.teckup.core.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table
@Data
@NoArgsConstructor
public class Matiere extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;



    @Column
    String label ;


    @Column
    Long nbrHeures;


    @OneToMany(mappedBy = "matiere", cascade = CascadeType.ALL)
    private Set<Absence> absences = new HashSet<>();

    @ManyToOne
    @JoinColumn
    private Classe classe;
}
