package com.example.demo.controller;


import com.example.demo.entities.Etudiant;
import com.example.demo.services.EtudiantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {

    private final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        super();
        this.etudiantService = etudiantService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Etudiant>> getAllEtudiant () {
        List<Etudiant> etudiants = etudiantService.findAllEtudiant();
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Etudiant> getEtudiantById (@PathVariable("id") Long id) {
        Etudiant etudiant = etudiantService.findEtudiantById(id);
        if(etudiant == null){
            throw new IllegalArgumentException("id not found");
        }
        return new ResponseEntity<>(etudiant, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Etudiant> addEtudiant (@RequestBody Etudiant etudiant) {
        Etudiant newEtudiant = etudiantService.addEtudiant(etudiant);
        System.out.println(etudiant);
        return new ResponseEntity<>(newEtudiant, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Etudiant> updateEtudiant (@RequestBody Etudiant etudiant) {
        Etudiant updateEtudiant = etudiantService.updateEtudiant(etudiant);
        return new ResponseEntity<>(updateEtudiant, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEtudiantById(@PathVariable("id") Long id) {
        etudiantService.deleteEtudiantById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
