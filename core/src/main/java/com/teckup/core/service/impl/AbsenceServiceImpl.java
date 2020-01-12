package com.teckup.core.service.impl;

import com.teckup.core.domain.Absence;
import com.teckup.core.domain.Etudiant;
import com.teckup.core.domain.Matiere;
import com.teckup.core.dto.AbsenceDto;
import com.teckup.core.repository.AbsenceRepository;
import com.teckup.core.repository.EtudiantRepository;
import com.teckup.core.service.AbsenceService;
import com.teckup.core.service.EtudiantService;
import com.teckup.core.service.MatiereService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service("absenceService")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AbsenceServiceImpl implements AbsenceService {


    final AbsenceRepository absenceRepository;

    final EtudiantService etudiantService;

    final MatiereService matiereService ;


    @Override
    public Absence save(AbsenceDto absence) {
        Etudiant etudiant = etudiantService.getEtudiant(absence.getMatricule());
        Matiere matiere = matiereService.getMatiere(absence.getMatierId());

        Absence absenceNew = new Absence();
        absenceNew.setMatieres(matiere);

    }
}
