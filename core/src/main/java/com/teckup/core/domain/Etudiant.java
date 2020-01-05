package com.teckup.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(schema = "gae")
@Data
@NoArgsConstructor
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy="etudiant", cascade=CascadeType.ALL)
    private Set<Matiere> matieres = new HashSet<>();

    @OneToMany(mappedBy="etudiant", cascade=CascadeType.ALL)
    private Set<Absence> absences = new HashSet<>();


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "classe_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Classe classe ;



}
