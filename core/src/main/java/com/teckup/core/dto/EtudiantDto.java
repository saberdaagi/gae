package com.teckup.core.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EtudiantDto {

    private String matricule ;
    private String nom ;
    private String prenom ;
    private String email;
    private String dateNaissance;
    private Long classeId ;
 }
