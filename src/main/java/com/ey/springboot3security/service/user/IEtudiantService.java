package com.ey.springboot3security.service.user;

import com.ey.springboot3security.entity.Etudiant;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEtudiantService {

    public Etudiant getEtudiantByEmail(String email);

    List<Etudiant> retrieveAllEtudiant();

    Etudiant addEtudiant (Etudiant e);

    ResponseEntity<Etudiant> updateEtudiant (Etudiant e);

    Etudiant retrieveEtudiant (Long idEtudiant);
    void removeEtudiant(Long idEtudiant);
}
