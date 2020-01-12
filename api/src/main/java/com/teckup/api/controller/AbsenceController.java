package com.teckup.api.controller;


import com.teckup.core.domain.Absence;
import com.teckup.core.dto.AbsenceDto;
import com.teckup.core.service.AbsenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/absence")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AbsenceController {


    final AbsenceService absenceService ;


    @PostMapping
    public Absence save(@RequestBody AbsenceDto absence){

       return  absenceService.save(absence);
    }
}
