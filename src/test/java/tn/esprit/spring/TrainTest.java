/*package tn.esprit.spring;

import tn.esprit.spring.entities.Train;
import tn.esprit.spring.entities.etatTrain;
import tn.esprit.spring.repository.TrainRepository;
import tn.esprit.spring.services.ITrainService;
import tn.esprit.spring.services.TrainServiceImpl;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;


import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class TrainTest  {


    @Mock
    TrainRepository trainRepository;

    @InjectMocks
    ITrainService trainService = new TrainServiceImpl();



    Train train = new Train(1,etatTrain.prevu,1);
    List<Train> listTrains = new ArrayList<Train>() {
        {
            add(new Train(1,etatTrain.prevu,1));
            add(new Train(1,etatTrain.prevu,1));
        }
    };


    /*  @Test
     void testRetrieveTrainByid() {

         when(trainRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(train));
         Train trainq = trainService.retrieveTrain(1L);

         System.out.println(trainq);
         Assertions.assertNotNull(trainq);
     }*/
 /*   @Test
    void testRetrieveAllTrain() {

        List<Train> trains = new ArrayList();
        trains.add(new Train());
        when(trainRepository.findAll()).thenReturn(trains);
        List<Train> expected = trainService.ListerTrainsIndirects(null, null);
        Assertions.assertEquals(expected, trains);
        verify(trainRepository).findAll();

    }



    @Test
    void testCreateNewObject() {
        Train obj = new Train(1,etatTrain.prevu,1);


        when(trainRepository.save(isA(Train.class))).thenAnswer(invocation -> (Train) invocation.getArguments()[0]);
        Train returnedObj = trainService.ajouterTrain(obj);
        ArgumentCaptor<Train> savedObjectArgument = ArgumentCaptor.forClass(Train.class);
        verify(trainRepository, times(1)).save(savedObjectArgument.capture());
        verifyNoMoreInteractions(trainRepository);

        Train savedRestObject = savedObjectArgument.getValue();
        Assertions.assertNotNull(savedRestObject);

    }
    

   /*  @Test
    void testDeleteObject() {
        Train train = new Train();
        train.setLibelleTrain("new test");
        train.setIdTrain(1L);
        when(trainRepository.findById(train.getIdTrain())).thenReturn(Optional.of(train));
        Train trainq = trainService.retrieveTrain(1L);
        trainService.deleteTrain(trainq.getIdTrain());
        verify(trainRepository).deleteById(trainq.getIdTrain());
    } */

//}