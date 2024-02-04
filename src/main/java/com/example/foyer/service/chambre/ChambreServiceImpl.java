package com.example.foyer.service.chambre;


import com.example.foyer.entity.Chambre;
import com.example.foyer.entity.Reservation;
import com.example.foyer.entity.TypeChambre;
import com.example.foyer.repository.ChambreRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService {
    ChambreRepo chambreRepo;

    @Override
    public List<Chambre> retrieveAllchambres() {
        return chambreRepo.findAll();
    }

    @Override
    public Chambre addchambres(Chambre c) {
        return chambreRepo.save(c);
    }

    @Override
    public Chambre updatechambres(Chambre c) {
        return chambreRepo.save(c);
    }

    @Override
    public Chambre retrievechambres(Long idChambre) {
        return chambreRepo.findById(idChambre).orElse(null);
    }

    @Override
    public void removeChambre(Long idChambre) {
        chambreRepo.deleteById(idChambre);
    }

    @Override
    public List<Chambre> getNomchambrebybloc(String nom) {
        return chambreRepo.findChambreByBloc_NomBloc(nom);
    }

    @Override
    public List<Chambre> getChambreByReservationAnneeUniversitaire(LocalDate debut, LocalDate fin) {
        List<Chambre> chambres = null;
            for (Chambre c : chambreRepo.findAll())
                for (Reservation r : c.getReservations())
                    if (r.getAnneUniversitaire().isAfter(debut) && r.getAnneUniversitaire().isBefore(fin))
                        chambres.add(c);
            return chambres;
        }

    @Override
    public List<Chambre> getChambresByIdBloc(Long idBloc) {
        return chambreRepo.findChambresByBloc_IdBloc(idBloc);
    }


    public long countchambrepartypeetbloc(TypeChambre typec, long idBloc) {
        return chambreRepo.countByTypecAndBloc_IdBloc(typec,idBloc);
    }


}
