package com.teckup.core.service;

import com.teckup.core.domain.Etudiant;

import java.util.List;

public interface EtudiantService {

    List<Etudiant> getAll();

    Etudiant getEtudiant(String matricule);

    Etudiant save(String matricule, String nom, String prenom, String email, String dateNaissance, Long classeId);
}
