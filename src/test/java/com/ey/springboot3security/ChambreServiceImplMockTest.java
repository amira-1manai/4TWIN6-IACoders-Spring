package com.ey.springboot3security;

import com.ey.springboot3security.entity.Chambre;
import com.ey.springboot3security.repository.BlocRepo;
import com.ey.springboot3security.repository.ChambreRepo;
import com.ey.springboot3security.service.chambre.ChambreServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class ChambreServiceImplMockTest {
    @Mock
    private ChambreRepo chambreRepo;

    @Mock
    private BlocRepo blocRepo;

    @InjectMocks
    private ChambreServiceImpl chambreService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddChambre() {
        Chambre chambre = new Chambre();
        when(chambreRepo.save(chambre)).thenReturn(chambre);

        Chambre savedChambre = chambreService.addChambre(chambre);

        assertEquals(chambre, savedChambre);
        verify(chambreRepo, times(1)).save(chambre);
    }

    @Test
    public void testAddChambres() {
        List<Chambre> chambres = new ArrayList<>();
        chambres.add(new Chambre());
        chambres.add(new Chambre());

        when(chambreRepo.saveAll(chambres)).thenReturn(chambres);

        List<Chambre> savedChambres = chambreService.addChambres(chambres);

        assertEquals(chambres, savedChambres);
        verify(chambreRepo, times(1)).saveAll(chambres);
    }
}
