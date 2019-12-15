package com.teckup.core.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "matière")
@Entity
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;


    private String label ;

    @Column(name = "nombre d'heures")
    private int nbr_heure;
}
