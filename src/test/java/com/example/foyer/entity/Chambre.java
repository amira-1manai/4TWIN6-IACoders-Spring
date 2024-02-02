package com.example.foyer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;
    long numeroChambre;
    @Enumerated(EnumType.STRING)
    TypeChambre Typec;
    @JsonIgnore
    @OneToMany
    Set<Reservation> reservations;
    @JsonIgnore
    @ManyToOne
    Bloc bloc;

}

}
