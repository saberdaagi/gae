package com.teckup.api.controller;


import com.teckup.core.domain.Classe;
import com.teckup.core.dto.ClasseDto;
import com.teckup.core.service.ClasseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Date;

import static org.springframework.http.HttpStatus.OK;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/classe")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClasseController {

    final ClasseService classeService ;


    @PostMapping
    @ResponseStatus(OK)
    public Classe save(@Valid @RequestBody ClasseDto classeDto){
        Classe classe = new Classe();
        classe.setLabel(classeDto.getLabel());
        classe.setNomComplet(classeDto.getNomComplet());
classe.setCreatedAt(new Date());
classe.setUpdatedAt(new Date());
        return classeService.save(classe);
    }


}
