package com.teckup.core.service;

import com.teckup.core.domain.Absence;
import com.teckup.core.dto.AbsenceDto;

public interface AbsenceService {
    Absence save(AbsenceDto absence);
}
