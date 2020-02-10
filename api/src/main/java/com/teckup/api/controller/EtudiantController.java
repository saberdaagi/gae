package com.isp.api.controller;

import com.isp.core.domain.User;
import com.isp.core.dto.EtudiantDto;
import com.isp.core.service.EtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;


@RestController
@RequestMapping("/api/etudiant")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EtudiantController {

    final EtudiantService etudiantService ;

    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<EtudiantDto> getAll(){
        return  etudiantService.getAll();
    }

    @PostMapping("/update")
    @CrossOrigin(origins = "http://localhost:4200")
    public User update(@RequestBody EtudiantDto etudiantDto) throws ParseException{
        return etudiantService.update(etudiantDto);
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public User save(@RequestBody EtudiantDto etudiantDto) throws ParseException {
        return etudiantService.save(etudiantDto);
    }

    @GetMapping
    @ResponseBody
    public User getEtudiant(@RequestParam String matricule){
        return etudiantService.getEtudiant(matricule);
    }

    @PostMapping(value = "/delete")
    public EtudiantDto delete(@RequestBody EtudiantDto etudiantDto){
         etudiantService.delete(Long.valueOf(etudiantDto.getId()));
        return etudiantDto;
    }
}
