package com.teckup.core.repository;

import com.teckup.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<User,Long> {

    User findByMatricule(String matricule);
}
