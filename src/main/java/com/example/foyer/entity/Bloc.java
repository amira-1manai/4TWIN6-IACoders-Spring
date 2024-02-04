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
public class Bloc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;

    String nomBloc;
    long capaciteBloc;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloc", fetch = FetchType.EAGER)
    Set<Chambre> chambres;


    @JsonIgnore
    @ManyToOne
    Foyer foyer;

}
