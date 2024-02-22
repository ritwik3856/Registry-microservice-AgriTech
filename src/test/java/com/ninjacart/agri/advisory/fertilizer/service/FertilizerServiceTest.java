//package com.ninjacart.agri.advisory.fertilizer.service;
//
//import com.ninjacart.agri.advisory.common.exception.EntityNotFoundException;
//import com.ninjacart.agri.advisory.fertilizer.event.FertilizerCreatedEvent;
//import com.ninjacart.agri.advisory.fertilizer.models.Fertilizer;
//import com.ninjacart.agri.advisory.fertilizer.repository.FertilizerRepository;
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
//import static org.mockito.Mockito.when;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.doNothing;
//
///**
// * Test class for FertilizerService.
// * This class uses Mockito to mock the FertilizerRepository and ApplicationEventPublisher
// * dependencies and tests the various methods of FertilizerService.
// */
//public class FertilizerServiceTest {
//
//    @Mock
//    private FertilizerRepository fertilizerRepository;
//
//    @Mock
//    private ApplicationEventPublisher eventPublisher;
//
//    @InjectMocks
//    private FertilizerService fertilizerService;
//
//    /**
//     * Sets up the test environment before each test.
//     * Initializes mocks and injects them into the fertilizerService object.
//     */
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
////        fertilizerService = new FertilizerService(fertilizerRepository, eventPublisher);
//    }
//
//    /**
//     * Tests the saveFertilizer method to ensure it saves a fertilizer and publishes an event.
//     */
//    @Test
//    void saveFertilizer() {
//        Fertilizer fertilizer = new Fertilizer(); // Initialize with test data
//        String createdBy = "testUser";
//        String createdByToolId = "testToolId";
//        when(fertilizerRepository.save(any(Fertilizer.class))).thenReturn(fertilizer);
//
//        Fertilizer savedFertilizer = fertilizerService.saveFertilizer(fertilizer, createdBy, createdByToolId);
//
//        verify(fertilizerRepository).save(fertilizer);
//        assertEquals(createdBy, savedFertilizer.getCreatedBy());
//        assertEquals(createdByToolId, savedFertilizer.getCreatedByToolId());
//        ArgumentCaptor<FertilizerCreatedEvent> eventCaptor = ArgumentCaptor.forClass(FertilizerCreatedEvent.class);
//        verify(eventPublisher).publishEvent(eventCaptor.capture());
//
//        FertilizerCreatedEvent capturedEvent = eventCaptor.getValue();
//        assertEquals(fertilizer.getId(), capturedEvent.getFertilizerId());
//    }
//
//    /**
//     * Tests getFertilizerById method to ensure it returns a fertilizer when found.
//     */
//    @Test
//    void getFertilizerByIdFound() {
//        Integer fertilizerId = 1;
//        Fertilizer fertilizer = new Fertilizer(); // Initialize with test data
//        when(fertilizerRepository.findById(fertilizerId)).thenReturn(Optional.of(fertilizer));
//
//        Optional<Fertilizer> result = fertilizerService.getFertilizerById(fertilizerId);
//
//        assertTrue(result.isPresent());
//        assertEquals(fertilizer, result.get());
//    }
//
//    /**
//     * Tests getFertilizerById method to ensure it handles cases where a fertilizer is not found.
//     */
//    @Test
//    void getFertilizerByIdNotFound() {
//        Integer fertilizerId = 1;
//        when(fertilizerRepository.findById(fertilizerId)).thenReturn(Optional.empty());
//
//        Optional<Fertilizer> result = fertilizerService.getFertilizerById(fertilizerId);
//
//        assertFalse(result.isPresent());
//    }
//
//    /**
//     * Tests getAllFertilizers method to ensure it returns all fertilizers.
//     */
//    @Test
//    void getAllFertilizers() {
//        List<Fertilizer> fertilizers = List.of(new Fertilizer(), new Fertilizer()); // Initialize with test data
//        when(fertilizerRepository.findAll()).thenReturn(fertilizers);
//
//        List<Fertilizer> result = fertilizerService.getAllFertilizers();
//
//        assertEquals(fertilizers.size(), result.size());
//    }
//
//    /**
//     * Tests deleteFertilizer method to ensure it correctly deletes a fertilizer.
//     */
//    @Test
//    void deleteFertilizer() {
//        Integer fertilizerId = 1;
//        doNothing().when(fertilizerRepository).deleteById(fertilizerId);
//
//        fertilizerService.deleteFertilizer(fertilizerId);
//
//        verify(fertilizerRepository).deleteById(fertilizerId);
//    }
//
//    /**
//     * Tests updateFertilizer method to ensure it updates a fertilizer correctly when found.
//     */
//    @Test
//    void updateFertilizer() {
//        Integer fertilizerId = 1;
//        Fertilizer fertilizer = new Fertilizer(); // Initialize with test data
//        String updatedBy = "testUserUpdate";
//        String updatedByToolId = "testToolIdUpdate";
//
//        // Prepare the expected returned fertilizer object
//        Fertilizer updatedFertilizer = new Fertilizer();
//        updatedFertilizer.setUpdatedBy(updatedBy);
//        updatedFertilizer.setUpdatedByToolId(updatedByToolId);
//
//        when(fertilizerRepository.findById(fertilizerId)).thenReturn(Optional.of(fertilizer));
//        when(fertilizerRepository.save(any(Fertilizer.class))).thenReturn(updatedFertilizer); // Return the expected object
//
//        Fertilizer result = fertilizerService.updateFertilizer(fertilizerId, new Fertilizer(), updatedBy, updatedByToolId);
//
//        assertNotNull(result);
//        assertEquals(updatedBy, result.getUpdatedBy());
//        assertEquals(updatedByToolId, result.getUpdatedByToolId());
//        verify(fertilizerRepository).save(any(Fertilizer.class));
//    }
//
//    /**
//     * Tests updateFertilizer method to ensure it throws an exception when the fertilizer is not found.
//     */
//    @Test
//    void updateFertilizerNotFound() {
//        Integer fertilizerId = 1;
//        String updatedBy = "testUserUpdate";
//        String updatedByToolId = "testToolIdUpdate";
//
//        when(fertilizerRepository.findById(fertilizerId)).thenReturn(Optional.empty());
//
//        Exception exception = assertThrows(EntityNotFoundException.class, () -> {
//            fertilizerService.updateFertilizer(fertilizerId, new Fertilizer(), updatedBy, updatedByToolId);
//        });
//
//        String expectedMessage = "Fertilizer not found for this id :: " + fertilizerId;
//        String actualMessage = exception.getMessage();
//
//        assertTrue(actualMessage.contains(expectedMessage));
//    }
//}
