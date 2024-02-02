package com.example.foyer.service.chambre;

import com.example.foyer.entity.Chambre;

import java.time.LocalDate;
import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllchambres();

    Chambre addchambres (Chambre c);

    Chambre updatechambres (Chambre c);

    Chambre retrievechambres (Long idChambre);
    void removeChambre(Long idChambre);

    List<Chambre> getNomchambrebybloc(String nom);
    List<Chambre> getChambreByReservationAnneeUniversitaire(LocalDate debut, LocalDate fin) ;

    List<Chambre> getChambresByIdBloc(Long idBloc);




}
