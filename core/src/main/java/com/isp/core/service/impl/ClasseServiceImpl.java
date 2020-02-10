package com.isp.core.service.impl;

import com.isp.core.domain.Classe;
import com.isp.core.dto.ClasseDto;
import com.isp.core.repository.ClasseRepository;
import com.isp.core.service.ClasseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public List<Classe> getAll() {
        List<Classe> classes = classeRepository.findAll();


        return classes;
    }


}
