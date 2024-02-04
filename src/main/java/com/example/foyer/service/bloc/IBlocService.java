package com.example.foyer.service.bloc;

import com.example.foyer.entity.Bloc;
import com.example.foyer.entity.Chambre;

import java.util.List;

public interface IBlocService {
    List<Bloc> retrieveAllBlocs();

    Bloc addBloc (Bloc b);

    Bloc updateBloc ( Bloc b);

    Bloc retrieveBloc (Long idBloc);
    void removeBloc(Long idBloc);

     Bloc affecterChambresABloc(List<Long> numeroChambre, String nomBloc) ;

     Bloc affecterBlocAFoyer(String nomBloc,String nomFoyer) ;

     List<Bloc> afficherBlocParIdFoyer(Long idFoyer);

    Bloc findBlocByChambresContaining(Chambre chambre);

}
