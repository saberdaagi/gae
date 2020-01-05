package com.teckup.core.service;

import com.teckup.core.domain.Classe;

import java.util.Optional;

public interface ClasseService  {

    Optional<Classe> getClasse(Long id);

    Classe save(Classe classe);
}
