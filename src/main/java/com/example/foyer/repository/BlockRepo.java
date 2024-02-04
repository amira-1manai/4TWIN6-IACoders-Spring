package com.example.foyer.repository;

import com.ey.springboot3security.entity.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockRepo extends JpaRepository<Bloc,Long> {

       // @Query("select b from Bloc b where b.nomBloc=:nom")

        //Bloc findBlocbyname(@Param("nom") String nom);
    Bloc findBlocByNomBloc(String nomBloc);

    List<Bloc> findBlocsByFoyer_IdFoyer(Long idFoyer);

    Bloc findBlocByChambresContaining(Chambre chambre);

}
