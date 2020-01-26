package com.teckup.api.controller;

import com.teckup.core.domain.User;
import com.teckup.core.dto.EtudiantDto;
import com.teckup.core.service.EtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/etudiant")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EtudiantController {

    final EtudiantService etudiantService ;

    @GetMapping("/all")
    public List<User> getAll(){
        return  etudiantService.getAll();
    }

    @GetMapping
    @ResponseBody
    public User getEtudiant(@RequestParam String matricule){
        return etudiantService.getEtudiant(matricule);
    }

    @PostMapping
    public User save(@RequestBody EtudiantDto etudiantDto) throws ParseException {
        return etudiantService.save(etudiantDto);


    }
}
