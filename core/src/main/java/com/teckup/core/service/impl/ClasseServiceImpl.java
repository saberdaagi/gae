package com.teckup.core.service.impl;

import com.teckup.core.domain.Classe;
import com.teckup.core.dto.ClasseDto;
import com.teckup.core.repository.ClasseRepository;
import com.teckup.core.service.ClasseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("classeService")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClasseServiceImpl implements ClasseService {

    final ClasseRepository classeRepository ;

    @Override
    public Optional<Classe> getClasse(Long id) {
        return classeRepository.findById(id);
    }

    @Override
    public Classe save(ClasseDto classeDto) {
        Classe classe = new Classe(classeDto.getLabel(),classeDto.getNomComplet());
        return classeRepository.save(classe);
    }



}
