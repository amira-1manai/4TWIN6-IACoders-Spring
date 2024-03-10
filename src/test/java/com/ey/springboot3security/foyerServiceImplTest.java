package com.ey.springboot3security;

import com.ey.springboot3security.entity.Bloc;
import com.ey.springboot3security.entity.Foyer;
import com.ey.springboot3security.repository.BlocRepo;
import com.ey.springboot3security.repository.FoyerRepo;
import com.ey.springboot3security.repository.UniversiteRepo;
import com.ey.springboot3security.service.foyer.foyerServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest


public class foyerServiceImplTest {
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

        assertNotNull(result);
        assertEquals(foyer, result);
        verify(foyerRepository, times(1)).save(foyer);
    }

    @Test
    void testAddFoyers() {
        List<Foyer> foyers = Arrays.asList(new Foyer(), new Foyer());
        when(foyerRepository.saveAll(foyers)).thenReturn(foyers);

        List<Foyer> result = foyerService.addFoyers(foyers);

        assertNotNull(result);
        assertEquals(foyers, result);
        verify(foyerRepository, times(1)).saveAll(foyers);
    }

    @Test
    void testFindAll() {
        List<Foyer> foyers = Arrays.asList(new Foyer(), new Foyer());
        when(foyerRepository.findAll()).thenReturn(foyers);

        List<Foyer> result = foyerService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(foyerRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        long id = 1L;
        Foyer foyer = new Foyer();
        when(foyerRepository.findById(id)).thenReturn(Optional.of(foyer));

        Foyer result = foyerService.findById(id);

        assertNotNull(result);
        assertEquals(foyer, result);
        verify(foyerRepository, times(1)).findById(id);
    }

    @Test
    void testDeleteById() {
        long id = 1L;

        foyerService.deleteById(id);

        verify(foyerRepository, times(1)).deleteById(id);
    }

    @Test
    void testDelete() {
        Foyer foyer = new Foyer();

        foyerService.delete(foyer);

        verify(foyerRepository, times(1)).delete(foyer);
    }

    @Test
    void testFindByNomFoyer() {
        String nomFoyer = "Foyer A";
        List<Foyer> foyers = Arrays.asList(new Foyer(), new Foyer());
        when(foyerRepository.findByNomFoyer(nomFoyer)).thenReturn(foyers);

        List<Foyer> result = foyerService.findByNomFoyer(nomFoyer);

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(foyerRepository, times(1)).findByNomFoyer(nomFoyer);
    }

    @Test
    void testGetFoyersByBloc() {
        Bloc bloc = new Bloc();
        List<Foyer> foyers = Arrays.asList(new Foyer(), new Foyer());
        when(foyerRepository.findByBloc(bloc)).thenReturn(foyers);

        List<Foyer> result = foyerService.getFoyersByBloc(bloc);

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(foyerRepository, times(1)).findByBloc(bloc);
    }


}
