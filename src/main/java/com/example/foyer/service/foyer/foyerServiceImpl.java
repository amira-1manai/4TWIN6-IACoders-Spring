package com.example.foyer.service.foyer;


import com.example.foyer.entity.Foyer;
import com.example.foyer.repository.FoyerRepo;
import com.ey.springboot3security.entity.Bloc;
import com.ey.springboot3security.entity.Foyer;
import com.ey.springboot3security.repository.BlockRepo;
import com.ey.springboot3security.repository.FoyerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class foyerServiceImpl implements IFoyerService {
    FoyerRepo foyerRepo;
    BlockRepo blockRepo;

    @Override
    public List<Foyer> retrieveAllFoyer() {
        return foyerRepo.findAll();
    }

    @Override
    public Foyer getFoyerById(Long idFoyer) {
        return foyerRepo.findById(idFoyer).orElse(null);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepo.save(foyer);
    }

    @Override
    public Foyer addFoyer(Foyer foyer) {
        foyer.setLikes(0);
        return foyerRepo.save(foyer);
    }

    @Override
    public void deleteFoyer(Long idFoyer) {
        foyerRepo.deleteById(idFoyer);
    }

    @Override
    public void incrementLike(String nomFoyer) {
        Foyer foyer = foyerRepo.findFoyerByNomFoyer(nomFoyer);
        long likes = foyer.getLikes();
        foyer.setLikes(likes + 1);
        foyerRepo.save(foyer);
    }

    @Override
    public void decrementLike(String nomFoyer) {
        Foyer foyer = foyerRepo.findFoyerByNomFoyer(nomFoyer);
        long likes = foyer.getLikes();
        if (likes > 0) {
            foyer.setLikes(likes - 1);
            foyerRepo.save(foyer);
        }
    }

    @Override
    public Foyer getFoyerByIdUniversite(Long idUniv) {
        return foyerRepo.findFoyersByUniversite_IdUniversite(idUniv);
    }

    @Override
    public Long getIdFoyerByIdUniversite(Long idUniversite) {
        Foyer foyer = foyerRepo.findFoyersByUniversite_IdUniversite(idUniversite);
        return foyer.getIdFoyer();
    }

    @Override
    public Foyer affecterBlocAFoyer(Long idBloc, Long idFoyer) {
        Bloc b = blockRepo.findById(idBloc).orElseThrow(() -> new RuntimeException("Bloc introuvable"));
        Foyer f = foyerRepo.findById(idFoyer).orElseThrow(() -> new RuntimeException("Foyer introuvable"));

        f.setBlocs(f.getBlocs() != null ? f.getBlocs() : new HashSet<>());
        f.getBlocs().add(b);
        b.setFoyer(f);
        blockRepo.save(b);

        return foyerRepo.save(f);
    }


}
