package com.teckup.core.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClasseDto {

    String label ;

    String nomComplet ;

    public ClasseDto(String label, String nomComplet) {
        this.label = label;
        this.nomComplet = nomComplet;
    }
}
