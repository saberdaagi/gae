package com.teckup.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(schema = "gae")
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


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "etudiant_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Etudiant etudiant ;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "absence_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Absence absence ;
}
