package tn.esprit.spring;

import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.entities.Ville;
import tn.esprit.spring.repository.VoyageRepository;
import tn.esprit.spring.services.IVoyageService;
import tn.esprit.spring.services.VoyageServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;


import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class VoyageTest  {


    @Mock
    VoyageRepository voyageRepository;

    @InjectMocks
    IVoyageService voyageService = new VoyageServiceImpl();



    Voyage voyage = new Voyage(1,Ville.tunis);
    List<Voyage> listVoyages = new ArrayList<Voyage>() {
        {
            add(new Voyage(1,Ville.tunis));
            add(new Voyage(1,Ville.tunis));
        }
    };


    /*  @Test
     void testRetrieveVoyageByid() {

         when(voyageRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(voyage));
         Voyage voyageq = voyageService.retrieveVoyage(1L);

         System.out.println(voyageq);
         Assertions.assertNotNull(voyageq);
     }*/
    @Test
    void testrecupererAll() {

        List<Voyage> voyages = new ArrayList();
        voyages.add(new Voyage());
        when(voyageRepository.findAll()).thenReturn(voyages);
        List<Voyage> expected = voyageService.recupererAll();
        Assertions.assertEquals(expected, voyages);
        verify(voyageRepository).findAll();

    }



    @Test
    void testCreateNewObject() {
        Voyage obj = new Voyage(1,Ville.tunis);


        when(voyageRepository.save(isA(Voyage.class))).thenAnswer(invocation -> (Voyage) invocation.getArguments()[0]);
        Voyage returnedObj = voyageService.ajouterVoyage(obj);
        ArgumentCaptor<Voyage> savedObjectArgument = ArgumentCaptor.forClass(Voyage.class);
        verify(voyageRepository, times(1)).save(savedObjectArgument.capture());
        verifyNoMoreInteractions(voyageRepository);

        Voyage savedRestObject = savedObjectArgument.getValue();
        Assertions.assertNotNull(savedRestObject);

    }
    

   /*  @Test
    void testDeleteObject() {
        Voyage voyage = new Voyage();
        voyage.setLibelleVoyage("new test");
        voyage.setIdVoyage(1L);
        when(voyageRepository.findById(voyage.getIdVoyage())).thenReturn(Optional.of(voyage));
        Voyage voyageq = voyageService.retrieveVoyage(1L);
        voyageService.deleteVoyage(voyageq.getIdVoyage());
        verify(voyageRepository).deleteById(voyageq.getIdVoyage());
    } */

}