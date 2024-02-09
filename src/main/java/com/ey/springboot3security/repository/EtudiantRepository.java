package com.ey.springboot3security.repository;

import com.ey.springboot3security.entity.Etudiant;
import com.ey.springboot3security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    Etudiant findEtudiantByUser_Email(String email);

    Etudiant findEtudiantByCin(long cin);
}
