package com.example.demo.controller;

import com.example.demo.entities.Absence;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Groupe;
import com.example.demo.entities.Justification;
import com.example.demo.repository.JustificationRepository;
import com.example.demo.services.JustificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/justification")
public class JustificationController {

    private final JustificationService justificationService;
    private final JustificationRepository justificationRepository;

    public JustificationController(JustificationService justificationService, JustificationRepository justificationRepository) {
        super();
        this.justificationService = justificationService;
        this.justificationRepository = justificationRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<Justification> addJustification (@RequestBody Justification justification) {
        Justification newJustification = justificationService.addJustification(justification);
        System.out.println(justification);
        return new ResponseEntity<>(newJustification, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Justification>> getAllJustification () {
        List<Justification> justification = justificationService.findAllEtudiant();
        return new ResponseEntity<>(justification, HttpStatus.OK);
    }
    @GetMapping("/find/byAbsenceId/{absence}")
    public ResponseEntity<Optional<List<Justification>>> getJustificationByAbsenceId (@PathVariable("absence") Absence absence) {
        Optional<List<Justification>> absences = justificationService.findJustificationByIdAbsence(absence);
        if(absences == null){
            throw new IllegalArgumentException("non Justification trouvé");
        }
        return new ResponseEntity<>(absences, HttpStatus.OK);
    }
}
