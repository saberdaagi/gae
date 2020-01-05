package com.teckup.core.service.impl;

import com.teckup.common.helper.DateHelper;
import com.teckup.core.domain.Classe;
import com.teckup.core.domain.Etudiant;
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
    public Etudiant save(String matricule, String nom, String prenom, String email, String dateNaissance, Long classeId) {

            Optional<Classe> classe = classeService.getClasse(classeId);
            classe.ifPresent(classeItem -> {

                Etudiant etudiant = new Etudiant();
                etudiant.setClasse(classeItem);
                etudiant.setNom(nom);
                etudiant.setPrenom(prenom);
                etudiant.setMatricule(matricule);
                try {
                    etudiant.setDateNaissance(DateHelper.parseToDate(dateNaissance));
                } catch (ParseException e) {
                    log.error("Error Occured {}",e.getMessage(),e);
                }
                etudiant.setEmail(email);

            });
            return null;
    }
}
