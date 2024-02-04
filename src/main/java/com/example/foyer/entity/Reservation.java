package com.example.foyer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {


    @Id
    String idReservation;
    LocalDate anneUniversitaire;
    Boolean estValide;
    @ManyToOne
    Etudiant etudiant;
    @ManyToOne
    Chambre chambre;
    String statuReservation;
    

}
