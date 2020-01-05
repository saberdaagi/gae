package com.teckup.core.repository;

import com.teckup.core.domain.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepository  extends JpaRepository<Absence,Long> {
}
