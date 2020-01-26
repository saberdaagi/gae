package com.teckup.core.service.impl;

import com.teckup.core.domain.Absence;
import com.teckup.core.domain.Matiere;
import com.teckup.core.domain.User;
import com.teckup.core.dto.AbsenceDto;
import com.teckup.core.repository.AbsenceRepository;
import com.teckup.core.service.AbsenceService;
import com.teckup.core.service.EtudiantService;
import com.teckup.core.service.MatiereService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("absenceService")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AbsenceServiceImpl implements AbsenceService {
    @Override
    public Absence save(AbsenceDto absence) {
        return null;
    }


    /*final AbsenceRepository absenceRepository;

    final EtudiantService etudiantService;

    final MatiereService matiereService ;


    @Override
    public Absence save(AbsenceDto absenceDto) {
        User etudiant =  etudiantService.getEtudiant(absenceDto.getMatricule());
        Matiere matiere  = matiereService.getMatiere(absenceDto.getMatierId());
        Absence absence  = new Absence() ;
        absence.setMatiere(matiere);
        absence.setUser(etudiant);
        absenceRepository.save(absence);
        return absence;
    }*/
}
