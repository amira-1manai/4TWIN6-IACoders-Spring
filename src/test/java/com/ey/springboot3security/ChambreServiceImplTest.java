package com.ey.springboot3security;

import com.ey.springboot3security.entity.Chambre;
import com.ey.springboot3security.repository.BlocRepo;
import com.ey.springboot3security.repository.ChambreRepo;
import com.ey.springboot3security.service.chambre.ChambreServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.ey.springboot3security.entity.Chambre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(SpringExtension.class)

public class ChambreServiceImplTest {
    @Mock
    private ChambreRepo chambreRepository;

    @Mock
    private BlocRepo blocRepository;

    @InjectMocks
    private ChambreServiceImpl service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddChambre() {
        Chambre chambre = new Chambre();
        when(chambreRepository.save(chambre)).thenReturn(chambre);

        Chambre result = service.addChambre(chambre);

        assertEquals(chambre, result);
        verify(chambreRepository, times(1)).save(chambre);
    }

    @Test
    public void testAddChambres() {
        List<Chambre> chambres = new ArrayList<>();
        // Ajoutez des données de test à la liste des chambres

        when(chambreRepository.saveAll(chambres)).thenReturn(chambres);

        List<Chambre> result = service.addChambres(chambres);

        assertEquals(chambres, result);
        verify(chambreRepository, times(1)).saveAll(chambres);
    }
}