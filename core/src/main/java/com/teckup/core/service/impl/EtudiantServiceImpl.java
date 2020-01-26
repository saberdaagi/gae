package com.teckup.core.service.impl;

import com.teckup.common.helper.DateHelper;
import com.teckup.core.domain.Classe;
import com.teckup.core.domain.User;
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

    final MatiereService matiereService;

    final ClasseService classeService;

    @Override
    public List<User> getAll() {
        return etudiantRepository.findAll();
    }

    @Override
    public User getEtudiant(String matricule) {
        return etudiantRepository.findByMatricule(matricule);
    }

    @Override
    public User save(EtudiantDto etudiantDto) throws ParseException {

        Optional<Classe> classeOptional = classeService.getClasse(etudiantDto.getClasseId());
        if (!classeOptional.isPresent()) {
            return null;
        }
        Classe classeItem = classeOptional.get();
        User etudiant = new User();

        etudiant.setClasse(classeItem);
        etudiant.setNom(etudiantDto.getNom());
        etudiant.setPrenom(etudiantDto.getPrenom());
        etudiant.setMatricule(etudiantDto.getMatricule());

        etudiant.setDateNaissance(DateHelper.parseToDate(etudiantDto.getDateNaissance()));
        etudiant.setEmail(etudiantDto.getEmail());
        etudiantRepository.save(etudiant);
        return etudiant;
    }
}
