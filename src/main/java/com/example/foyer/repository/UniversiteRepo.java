package com.example.foyer.repository;

import com.example.foyer.entity.Universite;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversiteRepo {
    Universite findUniversiteByNomUniversite(String nom);

    Universite findUniversiteByIdUniversite(long idUniversite);

}
