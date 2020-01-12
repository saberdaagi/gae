package com.teckup.core.service.impl;

import com.teckup.core.domain.Matiere;
import com.teckup.core.repository.MatiereRepository;
import com.teckup.core.service.MatiereService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("matiereService")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MatiereServiceImpl implements MatiereService {


   final MatiereRepository matiereRepository ;


   @Override
   public Matiere getMatiere(Long id) {
       return  matiereRepository.findById(id).get();
   }
}
