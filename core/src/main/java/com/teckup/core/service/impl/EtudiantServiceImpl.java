package com.teckup.core.service.impl;

import com.teckup.common.helper.DateHelper;
import com.teckup.core.constants.Role;
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
import java.util.ArrayList;
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
    public List<EtudiantDto> getAll()   {
        List<User> users = etudiantRepository.findAll();
        List<EtudiantDto> etudiantDto = new ArrayList<>();
        users.forEach(user ->{

                if (user.getClasse() != null) {
                    Long classeId =  user.getClasse().getId();

            etudiantDto.add( new EtudiantDto(user.getId().toString(), user.getMatricule(), user.getFirstName(), user.getLastName(), user.getGender(),user.getEmail(), user.getDateNaissance().toString(), classeId.toString()));
                }
        });
        return etudiantDto ;
    }

    @Override
    public User getEtudiant(String matricule) {
        return etudiantRepository.findByMatricule(matricule);
    }



    @Override
    public User save(EtudiantDto etudiantDto) throws ParseException {

        Optional<Classe> classeOptional = classeService.getClasse(Long.valueOf(etudiantDto.getClasseId()));
        if (!classeOptional.isPresent()) {
            return null;
        }
        Classe classeItem = classeOptional.get();
        User etudiant = new User();

        etudiant.setClasse(classeItem);
        etudiant.setFirstName(etudiantDto.getFirstName());
        etudiant.setLastName(etudiantDto.getLastName());
        etudiant.setMatricule(etudiantDto.getMatricule());
        etudiant.setGender(etudiantDto.getGender());
        etudiant.setRole(Role.USER);
        etudiant.setDateNaissance(DateHelper.parseToDate(etudiantDto.getDateNaissance()));
        etudiant.setEmail(etudiantDto.getEmail());
        etudiantRepository.save(etudiant);
        return etudiant;
    }

    @Override
    public User update(EtudiantDto etudiantDto) throws ParseException {
        User etudiant = etudiantRepository.findByMatricule(etudiantDto.getMatricule());
        Optional<Classe> classeOptional = classeService.getClasse(Long.valueOf(etudiantDto.getClasseId()));
        if (!classeOptional.isPresent()) {
            return null;
        }
        Classe classeItem = classeOptional.get();
        etudiant.setGender(etudiantDto.getGender());
        etudiant.setDateNaissance(DateHelper.parseToDate(etudiantDto.getDateNaissance()));
        etudiant.setEmail(etudiant.getEmail());
        etudiant.setClasse(classeItem);
        etudiant.setLastName(etudiantDto.getLastName());
        etudiant.setFirstName(etudiantDto.getFirstName());
        etudiantRepository.save(etudiant);
        return etudiant ;
    }

    @Override
    public void delete(Long id) {
        Optional<User> user = etudiantRepository.findById(id);
         etudiantRepository.delete(user.get());
    }


}
