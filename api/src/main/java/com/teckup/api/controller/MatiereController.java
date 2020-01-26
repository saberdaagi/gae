package com.teckup.api.controller;


import com.teckup.core.service.MatiereService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/matiere")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MatiereController {


    final MatiereService matiereSevice ;
}
