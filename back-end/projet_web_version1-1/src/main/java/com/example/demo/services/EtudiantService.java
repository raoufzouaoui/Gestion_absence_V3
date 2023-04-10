package com.example.demo.services;

import com.example.demo.entities.Etudiant;
import com.example.demo.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;

    @Autowired
    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    public Etudiant addEtudiant(Etudiant etudiant) {
        Optional<Etudiant> existingEmail = etudiantRepository.findEtudiantByEmail(etudiant.getEmail());
        Optional<Etudiant> existingCin = etudiantRepository.findEtudiantByCin(etudiant.getCin());
        if (existingEmail.isEmpty()) {
            if (existingCin.isEmpty()) {
                return etudiantRepository.save(etudiant);
            } else {
                throw new IllegalArgumentException("Cin already exists.");
            }
        } else {
            throw new IllegalArgumentException("Email already exists.");
        }

    }

    public List<Etudiant> findAllEtudiant(){
        return etudiantRepository.findAll();
    }

    public Etudiant updateEtudiant(Etudiant etudiant){
        return etudiantRepository.save(etudiant);
    }

    public Etudiant findEtudiantById(Long id) {
        return etudiantRepository.findEtudiantById(id)
                .orElseThrow(()-> new Error("User by id" + id +" was not found"));
    }
    @Transactional
    public void deleteEtudiantById(Long id){
        etudiantRepository.deleteEtudiantById(id);
    }



}
