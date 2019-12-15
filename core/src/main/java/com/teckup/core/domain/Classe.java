package com.teckup.core.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "classe")
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label ;

    @Column(name = "nom complet")
    private String nom_complet  ;

}
