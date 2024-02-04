package com.example.foyer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;
    private String nomEt;
    private String prenomEt;
    private LocalDate dateNaissance;
    @Column(unique = true)
    private long cin;
    private String ecole;
    private int numeroTelephone;
    private String adresse;
    private String ville;
    private int codePostal;
    private String specialite;

    @JsonIgnore
    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    List<Reservation> reservations;

    @OneToOne(cascade = CascadeType.ALL)
    User user;

}
