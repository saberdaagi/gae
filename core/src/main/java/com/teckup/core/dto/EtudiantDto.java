package com.teckup.core.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EtudiantDto {

    private String id ;
    private String matricule ;
    private String firstName ;
    private String lastName ;
    private String gender ;
    private String email;
    private String dateNaissance;
    private String classeId ;

    public EtudiantDto(String id , String matricule, String firstName, String lastName, String gender, String email, String dateNaissance, String classeId) {
        this.id = id ;
        this.matricule = matricule;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.classeId = classeId;
    }
}
