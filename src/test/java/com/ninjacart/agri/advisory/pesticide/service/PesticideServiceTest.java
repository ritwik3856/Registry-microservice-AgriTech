//package com.ninjacart.agri.advisory.pesticide.service;
//
//import com.ninjacart.agri.advisory.common.exception.EntityNotFoundException;
//import com.ninjacart.agri.advisory.pesticide.event.PesticideCreatedEvent;
//import com.ninjacart.agri.advisory.pesticide.models.Pesticide;
//import com.ninjacart.agri.advisory.pesticide.repository.PesticideRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentCaptor;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.context.ApplicationEventPublisher;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//import static org.mockito.Mockito.when;
//
///**
// * Test class for PesticideService.
// * This class uses Mockito to mock the PesticideRepository and ApplicationEventPublisher
// * dependencies and tests the various methods of PesticideService.
// */
//public class PesticideServiceTest {
//    @Mock
//    private PesticideRepository pesticideRepository;
//
//    @Mock
//    private ApplicationEventPublisher eventPublisher;
//
//    @InjectMocks
//    private PesticideService pesticideService;
//
//    /**
//     * Sets up the test environment before each test.
//     * Initializes mocks and injects them into the pesticideService object.
//     */
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
////        pesticideService = new PesticideService(pesticideRepository, eventPublisher);
//    }
//
//    /**
//     * Tests the savePesticide method to ensure it saves a pesticide and publishes an event.
//     */
//    @Test
//    void savePesticide() {
//        Pesticide pesticide = new Pesticide(); // Initialize with test data
//        Integer createdBy = 3856;
//        String createdByToolId = "testToolId";
//        when(pesticideRepository.save(any(Pesticide.class))).thenReturn(pesticide);
//
//        Pesticide savedPesticide= pesticideService.savePesticide(pesticide, createdBy, createdByToolId);
//
//        verify(pesticideRepository).save(pesticide);
//        assertEquals(createdBy, savedPesticide.getCreatedBy());
//        assertEquals(createdByToolId, savedPesticide.getCreatedByToolId());
//        ArgumentCaptor<PesticideCreatedEvent> eventCaptor = ArgumentCaptor.forClass(PesticideCreatedEvent.class);
//        verify(eventPublisher).publishEvent(eventCaptor.capture());
//
//        PesticideCreatedEvent capturedEvent = eventCaptor.getValue();
//        assertEquals(pesticide.getId(), capturedEvent.getPesticideId());
//    }
//
//    /**
//     * Tests getPesticideById method to ensure it returns a pesticide when found.
//     */
//    @Test
//    void getPesticideByIdFound() {
//        Integer pesticideId = 1;
//        Pesticide pesticide = new Pesticide(); // Initialize with test data
//        when(pesticideRepository.findById(pesticideId)).thenReturn(Optional.of(pesticide));
//
//        Optional<Pesticide> result = pesticideService.getPesticideById(pesticideId);
//
//        assertTrue(result.isPresent());
//        assertEquals(pesticide, result.get());
//    }
//
//    /**
//     * Tests getPesticideById method to ensure it handles cases where a pesticide is not found.
//     */
//    @Test
//    void getPesticideByIdNotFound() {
//        Integer pesticideId = 1;
//        when(pesticideRepository.findById(pesticideId)).thenReturn(Optional.empty());
//
//        Optional<Pesticide> result = pesticideService.getPesticideById(pesticideId);
//
//        assertFalse(result.isPresent());
//    }
//
//    /**
//     * Tests getAllPesticides method to ensure it returns all pesticides.
//     */
//    @Test
//    void getAllPesticides() {
//    List<Pesticide> pesticides = List.of(new Pesticide(), new Pesticide()); // Initialize with test data
//        when(pesticideRepository.findAll()).thenReturn(pesticides);
//
//        List<Pesticide> result = pesticideService.getAllPesticides();
//
//        assertEquals(pesticides.size(), result.size());
//    }
//
//    /**
//     * Tests deletePesticide method to ensure it correctly deletes a pesticide.
//     */
//    @Test
//    void deletePesticide() {
//        Integer pesticideId = 1;
//        doNothing().when(pesticideRepository).deleteById(pesticideId);
//
//        pesticideService.deletePesticide(pesticideId);
//
//        verify(pesticideRepository).deleteById(pesticideId);
//    }
//
//    /**
//     * Tests updatePesticide method to ensure it updates a pesticide correctly when found.
//     */
//    @Test
//    void updatePesticide() {
//        Integer pesticideId = 1;
//        Pesticide pesticide = new Pesticide(); // Initialize with test data
//        Integer updatedBy = 3856;
//        String updatedByToolId = "testToolIdUpdate";
//
//        Pesticide updatedPesticide = new Pesticide();
//        updatedPesticide.setUpdatedBy(updatedBy);
//        updatedPesticide.setUpdatedByToolId(updatedByToolId);
//
//        when(pesticideRepository.findById(pesticideId)).thenReturn(Optional.of(pesticide));
//        when(pesticideRepository.save(any(Pesticide.class))).thenReturn(updatedPesticide);
//
//        Pesticide result = pesticideService.updatePesticide(pesticideId, new Pesticide(), updatedBy, updatedByToolId);
//
//        assertNotNull(result);
//        assertEquals(updatedBy, result.getUpdatedBy());
//        assertEquals(updatedByToolId, result.getUpdatedByToolId());
//        verify(pesticideRepository).save(any(Pesticide.class));
//    }
//
//    /**
//     * Tests updatePesticide method to ensure it throws an exception when the pesticide is not found.
//     */
//    @Test
//    void updatePesticideNotFound() {
//        Integer pesticideId = 1;
//        String updatedBy = "testUserUpdate";
//        String updatedByToolId = "testToolIdUpdate";
//
//        when(pesticideRepository.findById(pesticideId)).thenReturn(Optional.empty());
//
//        Exception exception = assertThrows(EntityNotFoundException.class, () -> {
//            pesticideService.updatePesticide(pesticideId, new Pesticide(), updatedBy, updatedByToolId);
//        });
//
//        String expectedMessage = "Pesticide not found for this id :: " + pesticideId;
//        String actualMessage = exception.getMessage();
//
//        assertTrue(actualMessage.contains(expectedMessage));
//    }
//}
