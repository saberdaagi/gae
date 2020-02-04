package com.teckup.api.controller;


import com.teckup.core.domain.Classe;
import com.teckup.core.dto.ClasseDto;
import com.teckup.core.service.ClasseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/api/classe")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClasseController {

    final ClasseService classeService ;


    @PostMapping
    @ResponseStatus(OK)
    public Classe save(@Valid @RequestBody ClasseDto classe){
        return classeService.save(classe);
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Classe> getAll(){
        return classeService.getAll();
    }


}
