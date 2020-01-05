package com.teckup.core.repository;

import com.teckup.core.domain.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {

    Etudiant findByMatricule(String matricule);
}
