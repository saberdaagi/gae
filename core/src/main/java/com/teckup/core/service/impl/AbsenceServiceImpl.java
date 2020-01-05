package com.teckup.core.service.impl;

import com.teckup.core.repository.AbsenceRepository;
import com.teckup.core.service.AbsenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("absenceService")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AbsenceServiceImpl implements AbsenceService {


    final AbsenceRepository absenceRepository ;
}
