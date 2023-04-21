package com.example.demo.services;

import com.example.demo.entities.Absence;
import com.example.demo.entities.Etudiant;
import com.example.demo.repository.AbsenceRepository;
import com.example.demo.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbsenceService {
    private final AbsenceRepository absenceRepository;
    private final EtudiantRepository etudiantRepository ;

    @Autowired
    public AbsenceService(AbsenceRepository absenceRepository,
                          EtudiantRepository etudiantRepository) {
        this.absenceRepository = absenceRepository;
        this.etudiantRepository = etudiantRepository;
    }

    public Absence[] addAbsence(Absence[] absences) {
        for (int i = 0; i < absences.length; i++) {
            Etudiant etudiant = etudiantRepository.findById(absences[i].getEtudiant().getId()).orElse(null);
            if (etudiant != null) {
                absences[i].setEtudiant(etudiant);
                absenceRepository.save(absences[i]);
            } else {
                // handle case where etudiant is not found
            }
        }
        return absences;
    }

    public Absence findAbsenceById(Long id) {
        return absenceRepository.findAbsenceById(id)
                .orElseThrow(()-> new Error("Absence by id" + id +" was not found"));
    }
    public List<Absence> findAllAbsence(){
        return absenceRepository.findAll();
    }

    public Optional<List<Absence>> findAbsenceByEtudiant(Etudiant etudiant){
        return absenceRepository.findAbsenceByEtudiant(etudiant);
    }

}
