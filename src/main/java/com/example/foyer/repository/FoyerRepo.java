package com.example.foyer.repository;


import com.example.foyer.entity.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoyerRepo  extends JpaRepository<Foyer, Long> {

    Foyer findFoyerByNomFoyer(String nomFoyer);

    Foyer findFoyersByUniversite_IdUniversite(Long idUniv);
}
