package com.teckup.core.service;

import com.teckup.core.domain.Etudiant;
import com.teckup.core.dto.EtudiantDto;

import java.util.List;

public interface EtudiantService {

    List<Etudiant> getAll();

    Etudiant getEtudiant(String matricule);
    
    Etudiant save(EtudiantDto etudiantDto);
}
