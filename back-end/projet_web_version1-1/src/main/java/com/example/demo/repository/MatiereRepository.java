package com.example.demo.repository;

import com.example.demo.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Long> {

    Optional<Matiere> findMatiereById(Long id);

    Optional<Matiere> findMatiereByNom(String nom);
}
