//package com.ninjacart.agri.advisory.seed.service;
//
//import com.ninjacart.agri.advisory.common.exception.EntityNotFoundException;
//import com.ninjacart.agri.advisory.seed.models.Seed;
//import com.ninjacart.agri.advisory.seed.repository.SeedRepository;
//import com.ninjacart.agri.advisory.seed.event.SeedCreatedEvent;
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
//
///**
// * Test class for SeedService.
// * This class uses Mockito to mock the SeedRepository and ApplicationEventPublisher
// * dependencies and tests the various methods of SeedService.
// */
//public class SeedServiceTest {
//
//    @Mock
//    private SeedRepository seedRepository;
//
//    @Mock
//    private ApplicationEventPublisher eventPublisher;
//
//    @InjectMocks
//    private SeedService seedService;
//
//    /**
//     * Sets up the test environment before each test.
//     * Initializes mocks and injects them into the seedService object.
//     */
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    /**
//     * Tests the saveSeed method to ensure it saves a seed and publishes an event.
//     */
//    @Test
//    void saveSeed() {
//        Seed seed = new Seed(); // Initialize with test data
//        Integer createdBy = 3856;
//        String createdByToolId = "testToolId";
//        when(seedRepository.save(any(Seed.class))).thenReturn(seed);
//
//        Seed savedSeed = seedService.saveSeed(seed, createdBy, createdByToolId);
//
//        verify(seedRepository).save(seed);
//        assertEquals(createdBy, savedSeed.getCreatedBy());
//        assertEquals(createdByToolId, savedSeed.getCreatedByToolId());
//        ArgumentCaptor<SeedCreatedEvent> eventCaptor = ArgumentCaptor.forClass(SeedCreatedEvent.class);
//        verify(eventPublisher).publishEvent(eventCaptor.capture());
//
//        SeedCreatedEvent capturedEvent = eventCaptor.getValue();
//        assertEquals(seed.getId(), capturedEvent.getSeedId());
//    }
//
//    /**
//     * Tests getSeedById method to ensure it returns a seed when found.
//     */
//    @Test
//    void getSeedByIdFound() {
//        Integer seedId = 1;
//        Seed seed = new Seed(); // Initialize with test data
//        when(seedRepository.findById(seedId)).thenReturn(Optional.of(seed));
//
//        Optional<Seed> result = seedService.getSeedById(seedId);
//
//        assertTrue(result.isPresent());
//        assertEquals(seed, result.get());
//    }
//
//    /**
//     * Tests getSeedById method to ensure it handles cases where a seed is not found.
//     */
//    @Test
//    void getSeedByIdNotFound() {
//        Integer seedId = 1;
//        when(seedRepository.findById(seedId)).thenReturn(Optional.empty());
//
//        Optional<Seed> result = seedService.getSeedById(seedId);
//
//        assertFalse(result.isPresent());
//    }
//
//    /**
//     * Tests getAllSeeds method to ensure it returns all seeds.
//     */
//    @Test
//    void getAllSeeds() {
//        List<Seed> seeds = List.of(new Seed(), new Seed()); // Initialize with test data
//        when(seedRepository.findAll()).thenReturn(seeds);
//
//        List<Seed> result = seedService.getAllSeeds();
//
//        assertEquals(seeds.size(), result.size());
//    }
//
//    /**
//     * Tests deleteSeed method to ensure it correctly deletes a seed.
//     */
//    @Test
//    void deleteSeed() {
//        Integer seedId = 1;
//        doNothing().when(seedRepository).deleteById(seedId);
//
//        seedService.deleteSeed(seedId);
//
//        verify(seedRepository).deleteById(seedId);
//    }
//
//    /**
//     * Tests updateSeed method to ensure it updates a seed correctly when found.
//     */
//    @Test
//    void updateSeed() {
//        Integer seedId = 1;
//        Seed seed = new Seed(); // Initialize with test data
//        Integer updatedBy = 3856;
//        String updatedByToolId = "testToolIdUpdate";
//
//        Seed updatedSeed = new Seed();
//        updatedSeed.setUpdatedBy(updatedBy);
//        updatedSeed.setUpdatedByToolId(updatedByToolId);
//
//        when(seedRepository.findById(seedId)).thenReturn(Optional.of(seed));
//        when(seedRepository.save(any(Seed.class))).thenReturn(updatedSeed);
//
//        Seed result = seedService.updateSeed(seedId, new Seed(), updatedBy, updatedByToolId);
//
//        assertNotNull(result);
//        assertEquals(updatedBy, result.getUpdatedBy());
//        assertEquals(updatedByToolId, result.getUpdatedByToolId());
//        verify(seedRepository).save(any(Seed.class));
//    }
//
//    /**
//     * Tests updateSeed method to ensure it throws an exception when the seed is not found.
//     */
//    @Test
//    void updateSeedNotFound() {
//        Integer seedId = 1;
//        Integer updatedBy = 3856;
//        String updatedByToolId = "testToolIdUpdate";
//
//        when(seedRepository.findById(seedId)).thenReturn(Optional.empty());
//
//        Exception exception = assertThrows(EntityNotFoundException.class, () -> {
//            seedService.updateSeed(seedId, new Seed(), updatedBy, updatedByToolId);
//        });
//
//        String expectedMessage = "Seed not found for this id :: " + seedId;
//        String actualMessage = exception.getMessage();
//
//        assertTrue(actualMessage.contains(expectedMessage));
//    }
//}
