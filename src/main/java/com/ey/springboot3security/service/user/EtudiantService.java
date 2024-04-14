package com.ey.springboot3security.service.user;

import com.ey.springboot3security.entity.Etudiant;
import com.ey.springboot3security.entity.Reservation;
import com.ey.springboot3security.entity.User;
import com.ey.springboot3security.repository.EtudiantRepository;
import com.ey.springboot3security.repository.UserInfoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantService implements IEtudiantService {

    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    UserInfoRepository userRepository;

    @Override
    public Etudiant getEtudiantByEmail(String email) {
        return this.etudiantRepository.findEtudiantByUser_Email(email);
    }

    @Override
    public List<Etudiant> retrieveAllEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);

    }

    @Override
    public ResponseEntity<Etudiant> updateEtudiant(Etudiant etudiant) {
        User user = userRepository.findUserByEmail(etudiant.getUser().getEmail()).orElse(null);
        if (user != null) {
            etudiant.setUser(user);
            return ResponseEntity.ok().body(etudiantRepository.save(etudiant));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
}
