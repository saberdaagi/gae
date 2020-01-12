package com.teckup.core.service.impl;

import com.teckup.common.helper.DateHelper;
import com.teckup.core.domain.Classe;
import com.teckup.core.domain.Etudiant;
import com.teckup.core.dto.EtudiantDto;
import com.teckup.core.repository.EtudiantRepository;
import com.teckup.core.service.ClasseService;
import com.teckup.core.service.EtudiantService;
import com.teckup.core.service.MatiereService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service("etudiantService")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class EtudiantServiceImpl implements EtudiantService {



    final EtudiantRepository etudiantRepository;

    final MatiereService matiereService ;

    final ClasseService classeService ;

    @Override
    public List<Etudiant> getAll() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiant(String matricule) {
        return etudiantRepository.findByMatricule(matricule);
    }

    @Override
    public Etudiant save(EtudiantDto etudiantDto) {

            Optional<Classe> classeOptional = classeService.getClasse(etudiantDto.getClasseId());
            Classe classeItem = (Classe) classeOptional.get();


                Etudiant etudiant = new Etudiant();

                etudiant.setClasse(classeItem);
                etudiant.setNom(etudiantDto.getNom());
                etudiant.setPrenom(etudiantDto.getPrenom());
                etudiant.setMatricule(etudiantDto.getMatricule());
                try {
                    etudiant.setDateNaissance(DateHelper.parseToDate(etudiantDto.getDateNaissance()));
                } catch (ParseException e) {
                    log.error("Error Occured {}",e.getMessage(),e);
                }
                etudiant.setEmail(etudiantDto.getEmail());
        etudiantRepository.save(etudiant);
           return etudiant ;
    }
}
