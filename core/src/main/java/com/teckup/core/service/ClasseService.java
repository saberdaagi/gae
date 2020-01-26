package com.teckup.core.service;

import com.teckup.core.domain.Classe;
import com.teckup.core.dto.ClasseDto;

import java.util.Optional;

public interface ClasseService  {

    Optional<Classe> getClasse(Long id);

    Classe save(ClasseDto classe);
}
