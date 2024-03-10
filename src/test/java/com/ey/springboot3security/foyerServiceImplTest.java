package com.ey.springboot3security;

import com.ey.springboot3security.entity.Bloc;
import com.ey.springboot3security.entity.Foyer;
import com.ey.springboot3security.entity.Universite;
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

import static org.junit.jupiter.api.Assertions.*;
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



    @Test
    void testAjoutFoyerEtBloc() {
        Foyer foyer = new Foyer();
        Bloc bloc1 = new Bloc();
        Bloc bloc2 = new Bloc();
        foyer.setBloc(Arrays.asList(bloc1, bloc2));

        when(foyerRepository.save(foyer)).thenReturn(foyer);

        Foyer result = foyerService.ajoutFoyerEtBloc(foyer);

        assertNotNull(result);
        assertEquals(foyer, result);
        verify(foyerRepository, times(1)).save(foyer);
        verify(blocRepository, times(2)).save(any(Bloc.class));
    }



    @Test
    void testAffecterFoyerAUniversite() {
        long idFoyer = 1L;
        String nomUniversite = "Universite A";
        Foyer foyer = new Foyer();
        Universite universite = new Universite();

        when(foyerRepository.findById(idFoyer)).thenReturn(Optional.of(foyer));
        when(universiteRepository.findByNomUniversite(nomUniversite)).thenReturn(Arrays.asList(universite));

        Universite result = foyerService.affecterFoyerAUniversite(idFoyer, nomUniversite);

        assertNotNull(result);
        assertEquals(universite, result);
        assertEquals(foyer, universite.getFoyer());
        verify(foyerRepository, times(1)).findById(idFoyer);
        verify(universiteRepository, times(1)).findByNomUniversite(nomUniversite);
        verify(universiteRepository, times(1)).save(universite);
    }

    @Test
    void testDesaffecterFoyerAUniversite() {
        long idUniversite = 1L;
        Universite universite = new Universite();
        universite.setFoyer(new Foyer());

        when(universiteRepository.findById(idUniversite)).thenReturn(Optional.of(universite));
        when(universiteRepository.save(universite)).thenReturn(universite);

        Universite result = foyerService.desaffecterFoyerAUniversite(idUniversite);

        assertNotNull(result);
        assertNull(result.getFoyer());
        verify(universiteRepository, times(1)).findById(idUniversite);
        verify(universiteRepository, times(1)).save(universite);
    }




    @Test
    void testDeleteFoyerAndDesaffecterUniversite() {
        Long id = 1L;
        Foyer foyer = new Foyer();
        Universite universite = new Universite();
        Bloc bloc1 = new Bloc();
        Bloc bloc2 = new Bloc();

        foyer.setId(id);
        foyer.setUniversite(universite);
        foyer.setBloc(Arrays.asList(bloc1, bloc2));

        when(foyerRepository.findById(id)).thenReturn(Optional.of(foyer));

        foyerService.deleteFoyerAndDesaffecterUniversite(id);

        assertNull(universite.getFoyer());
        verify(blocRepository, times(2)).save(any(Bloc.class));
        verify(universiteRepository, times(1)).save(universite);
        verify(foyerRepository, times(1)).deleteById(id);
    }



}
