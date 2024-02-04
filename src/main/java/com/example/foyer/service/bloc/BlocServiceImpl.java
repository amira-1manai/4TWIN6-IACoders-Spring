package com.example.foyer.service.bloc;


import com.ey.springboot3security.entity.Bloc;
import com.ey.springboot3security.repository.BlockRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor

public class BlocServiceImpl implements IBlocService{
    BlockRepo blocrepo;
    ChambreRepo chambrerepo;
    FoyerRepo foyerrepo;
    @Override
    public List<Bloc> retrieveAllBlocs() {
       return blocrepo.findAll();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocrepo.save(b);
    }

    @Override
    public Bloc updateBloc(Bloc b) {
        return blocrepo.save(b);
    }

    @Override
    public Bloc retrieveBloc(Long idBloc) {
        return blocrepo.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(Long idBloc) {
        blocrepo.deleteById(idBloc);

    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numeroChambre, String nomBloc) {
        Bloc bloc = blocrepo.findBlocByNomBloc(nomBloc);
        Set<Chambre> chambres = new HashSet<>();

        for (Long num : numeroChambre) {
            Chambre chambre = chambrerepo.findChambreByNumeroChambre(num);

            if (chambre != null) {
                chambre.setBloc(bloc);
                chambrerepo.save(chambre); // Save the chambre first
                chambres.add(chambre);
            }
        }

        bloc.setChambres(bloc.getChambres() != null ? bloc.getChambres() : new HashSet<>());
        bloc.getChambres().addAll(chambres);

        return blocrepo.save(bloc);
    }

    @Override
    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer) {

        Bloc bloc = blocrepo.findBlocByNomBloc(nomBloc);

        if (bloc == null) {

            return null;
        }

        Foyer foyer = foyerrepo.findFoyerByNomFoyer(nomFoyer);

        if (foyer == null) {

            return null;
        }

        bloc.setFoyer(foyer);

        blocrepo.save(bloc);

        return bloc;
    }

    @Override
    public List<Bloc> afficherBlocParIdFoyer(Long idFoyer) {
        return blocrepo.findBlocsByFoyer_IdFoyer(idFoyer);
    }


    @Override
    public Bloc findBlocByChambresContaining(Chambre chambre){
        return blocrepo.findBlocByChambresContaining(chambre);
    }

}
