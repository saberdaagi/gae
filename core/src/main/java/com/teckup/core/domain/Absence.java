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
public class Absence extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "etudiant_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Etudiant etudiant ;

    @OneToMany(mappedBy="absence", cascade=CascadeType.ALL)
    private Set<Matiere> matieres = new HashSet<>();

}
