package com.example.foyer.repository;

import com.example.foyer.entity.Chambre;
import com.example.foyer.entity.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreRepo extends JpaRepository<Chambre,Long> {
//recuperer les chmabres qui ont été reservé dans l'anneé universitaire donné au clavier



    List<Chambre> findChambreByBloc_NomBloc(String nom);

    Chambre findChambreByNumeroChambre(long numeroChambre);
    //recupere les chambres définis par leur nom
    //List<Chambre> findChambresByBloc_nomBloc();


    // int countByTypecAndBloc_IdBloc(TypeChambre typeChambre,long id);
    @Query("SELECT COUNT(c) FROM Chambre c WHERE c.Typec = :type AND c.bloc.idBloc = :idBloc")
    long countByTypecAndBloc_IdBloc(@Param("type") TypeChambre type, @Param("idBloc") long idBloc);

    List<Chambre> findChambresByBloc_IdBloc(Long idBloc);

}
