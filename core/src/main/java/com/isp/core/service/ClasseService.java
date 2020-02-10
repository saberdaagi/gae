package com.isp.core.service;

import com.isp.core.domain.Classe;
import com.isp.core.dto.ClasseDto;

import java.util.List;
import java.util.Optional;

public interface ClasseService  {

    Optional<Classe> getClasse(Long id);

    Classe save(ClasseDto classe);

    List<Classe> getAll();
}
