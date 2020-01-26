package com.teckup.core.service;

import com.teckup.core.domain.User;
import com.teckup.core.dto.EtudiantDto;

import java.text.ParseException;
import java.util.List;

public interface EtudiantService {

    List<User> getAll();

    User getEtudiant(String matricule);
    
    User save(EtudiantDto etudiantDto) throws ParseException;
}
