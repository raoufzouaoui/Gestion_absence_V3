package com.example.demo.controller;


import com.example.demo.entities.Enseignant;
import com.example.demo.repository.EnseignantRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/user", method = RequestMethod.POST)
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EnseignantController {

    @Autowired
    private EnseignantRepository repo;
    @PostMapping("/register")
    public ResponseEntity<Enseignant> registerUser(@RequestBody Enseignant user) {
        System.out.println(user);
        return ResponseEntity.ok(repo.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<Enseignant> loginUser(@RequestBody Enseignant enseignant) {
        Enseignant user = repo.findByEmail(enseignant.getEmail());
        if(user.getPassword().equals(enseignant.getPassword())){
            return ResponseEntity.ok(user);
        }
        return (ResponseEntity<Enseignant>) ResponseEntity.internalServerError();
    }


}
