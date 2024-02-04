package com.example.foyer.service.foyer;


import com.example.foyer.entity.Foyer;

import java.util.List;

public interface IFoyerService {

    List<Foyer> retrieveAllFoyer();

    Foyer getFoyerById(Long idFoyer);

    Foyer updateFoyer (Foyer  foyer);

    Foyer addFoyer (Foyer foyer);

    void deleteFoyer (Long idFoyer);

    void incrementLike(String nomFoyer);

    void decrementLike(String nomFoyer);

    Foyer getFoyerByIdUniversite(Long idUniv);

    Long getIdFoyerByIdUniversite(Long idUniversite);

    Foyer affecterBlocAFoyer(Long idBloc,Long idFoyer);
}
