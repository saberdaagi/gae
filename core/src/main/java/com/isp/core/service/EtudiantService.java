package com.isp.core.service;

import com.isp.core.domain.User;
import com.isp.core.dto.EtudiantDto;

import java.text.ParseException;
import java.util.List;

public interface EtudiantService {

    List<EtudiantDto> getAll();

    User getEtudiant(String matricule);
    
    User save(EtudiantDto etudiantDto) throws ParseException;

    User update(EtudiantDto etudiantDto)  throws ParseException;

    void delete(Long id);
}
