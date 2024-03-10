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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


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

    @Test
    public void testGetChambreById() {
        Long id = 1L;
        Chambre chambre = new Chambre();
        chambre.setId(id);

        when(chambreRepo.findById(id)).thenReturn(Optional.of(chambre));

        Optional<Chambre> retrievedChambre = chambreService.getChambreById(id);

        assertTrue(retrievedChambre.isPresent());
        assertEquals(chambre, retrievedChambre.get());
        verify(chambreRepo, times(1)).findById(id);
    }

    @Test
    public void testGetAllChambres() {
        List<Chambre> chambres = new ArrayList<>();
        chambres.add(new Chambre());
        chambres.add(new Chambre());

        when(chambreRepo.findAll()).thenReturn(chambres);

        List<Chambre> retrievedChambres = chambreService.getAllChambres();

        assertEquals(chambres.size(), retrievedChambres.size());
        assertEquals(chambres, retrievedChambres);
        verify(chambreRepo, times(1)).findAll();
    }

    @Test
    public void testDeleteChambre() {
        Long id = 1L;
        Chambre chambre = new Chambre();
        chambre.setIdChambre(id);  // Utilisez setIdChambre au lieu de setId

        when(chambreRepo.findById(id)).thenReturn(Optional.of(chambre));

        chambreService.deleteChambre(id);

        verify(chambreRepo, times(1)).deleteById(id);  // Utilisez deleteById au lieu de delete(chambre)
    }
    @Test
    public void testCalculatePourcentage() {
        int totalChambres = 10;
        int chambresOccupees = 7;
        double expectedPourcentage = (double) chambresOccupees / totalChambres * 100;

        when(chambreRepo.count()).thenReturn((long) totalChambres);
        when(chambreRepo.countByOccupied(true)).thenReturn(chambresOccupees);

        double calculatedPourcentage = chambreService.calculatePourcentageOccupation();

        assertEquals(expectedPourcentage, calculatedPourcentage, 0.01);
        verify(chambreRepo, times(1)).count();
        verify(chambreRepo, times(1)).countByOccupied(true);
    }
}