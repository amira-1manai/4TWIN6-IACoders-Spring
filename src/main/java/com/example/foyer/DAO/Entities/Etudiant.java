package com.example.foyer.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name = "etudiant")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEtudiant;

    @Column(name = "nomEt")
    private String nomEt;

    @Column(name = "prenomEt")
    private String prenomEt;

    @Column(name = "cin")
    private long cin;

    @Column(name = "ecole")
    private String ecole;

    @Column(name = "dateNaissance")
    private Date dateNaissance; //JJ/MM/YYYY


    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "passwordDecoder")
    private String passwordDecoder;

    @Column(name = "mFaEnabled")
    private boolean mFaEnabled;

    @Column(name = "secret")
    private String secret;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @ManyToMany(mappedBy = "etudiants",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Reservation> reservations = new HashSet<>();

    @OneToMany(mappedBy = "etudiant")
    @JsonIgnore
    private List<Token> tokens ;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

