package com.ey.springboot3security;

import com.ey.springboot3security.entity.Bloc;
import com.ey.springboot3security.entity.Foyer;
import com.ey.springboot3security.entity.Universite;
import com.ey.springboot3security.repository.BlocRepo;
import com.ey.springboot3security.repository.FoyerRepo;
import com.ey.springboot3security.repository.UniversiteRepo;
import com.ey.springboot3security.service.foyer.foyerServiceImpl;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest


public class foyerServiceMockTest {
    @Mock
    private FoyerRepo foyerRepository;

    @Mock
    private BlocRepo blocRepository;

    @Mock
    private UniversiteRepo universiteRepository;

    @InjectMocks
    private foyerServiceImpl foyerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddFoyer() {
        Foyer foyer = new Foyer();
        when(foyerRepository.save(foyer)).thenReturn(foyer);

        Foyer result = foyerService.addFoyer(foyer);

        assertEquals(foyer, result);
        verify(foyerRepository, times(1)).save(foyer);
    }

    @Test
    void testAddFoyers() {
        List<Foyer> foyers = new ArrayList<>();
        when(foyerRepository.saveAll(foyers)).thenReturn(foyers);

        List<Foyer> result = foyerService.addFoyers(foyers);

        assertEquals(foyers, result);
        verify(foyerRepository, times(1)).saveAll(foyers);
    }

    @Test
    void testEditFoyer() {
        Foyer foyer = new Foyer();
        when(foyerRepository.save(foyer)).thenReturn(foyer);

        Foyer result = foyerService.editFoyer(foyer);

        assertEquals(foyer, result);
        verify(foyerRepository, times(1)).save(foyer);
    }



    @Test
    void testFindAll() {
        List<Foyer> foyers = new ArrayList<>();
        when(foyerRepository.findAll()).thenReturn(foyers);

        List<Foyer> result = foyerService.findAll();

        assertEquals(foyers, result);
        verify(foyerRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        long id = 1L;
        Foyer foyer = new Foyer();
        when(foyerRepository.findById(id)).thenReturn(Optional.of(foyer));

        Foyer result = foyerService.findById(id);

        assertEquals(foyer, result);
        verify(foyerRepository, times(1)).findById(id);
    }

    @Test
    void testDeleteById() {
        long id = 1L;
        doNothing().when(foyerRepository).deleteById(id);

        foyerService.deleteById(id);

        verify(foyerRepository, times(1)).deleteById(id);
    }

    @Test
    void testDelete() {
        Foyer foyer = new Foyer();
        doNothing().when(foyerRepository).delete(foyer);

        foyerService.delete(foyer);

        verify(foyerRepository, times(1)).delete(foyer);
    }

    @Test
    void testFindByNomFoyer() {
        String nomFoyer = "Foyer1";
        List<Foyer> foyers = new ArrayList<>();
        when(foyerRepository.findByNomFoyer(nomFoyer)).thenReturn(foyers);

        List<Foyer> result = foyerService.findByNomFoyer(nomFoyer);

        assertEquals(foyers, result);
        verify(foyerRepository, times(1)).findByNomFoyer(nomFoyer);
    }

    @Test
    void testGetFoyersByBloc() {
        Bloc bloc = new Bloc();
        List<Foyer> foyers = new ArrayList<>();
        when(foyerRepository.findByBloc(bloc)).thenReturn(foyers);

        List<Foyer> result = foyerService.getFoyersByBloc(bloc);

        assertEquals(foyers, result);
        verify(foyerRepository, times(1)).findByBloc(bloc);
    }



}
