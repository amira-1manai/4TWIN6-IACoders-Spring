package com.example.foyer.repository;

import com.example.foyer.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    Etudiant findEtudiantByUser_Email(String email);

    Etudiant findEtudiantByCin(long cin);
}
