package com.ninjacart.agri.advisory.crop.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.HitsMetadata;
import com.ninjacart.agri.advisory.crop.models.Crop;
import com.ninjacart.agri.advisory.crop.repository.CropRepository;
import com.ninjacart.agri.advisory.crop.repository.CropRepo;
import com.ninjacart.agri.advisory.refdata.models.EppoCode;
import com.ninjacart.agri.advisory.refdata.models.UnspscCode;
import org.jooq.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.function.Function;

/**
 * Test class for CropService. This class uses Mockito to mock the CropRepository and
 * ApplicationEventPublisher dependencies and tests the various methods of CropService.
 */
public class CropServiceTest {

    @Mock private CropRepository cropRepository;

    @Mock private CropRepo cropRepo;

    @Mock private ElasticsearchClient elasticsearchClient;

    @Mock private ApplicationEventPublisher eventPublisher;

    @InjectMocks private CropService cropService;


    /**
     * Sets up the test environment before each test. Initializes mocks and injects them into the
     * cropService object.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    /** Tests the saveCrop method to ensure it saves a crop and publishes an event. */
    @Test
    void saveCrop() {
        Crop crop = new Crop();
        if (crop.getEppocode() == null) {
            crop.setEppocode(new EppoCode()); // Assuming EppoCode has a default constructor
        }
        if (crop.getUnspsc() == null) {
            crop.setUnspsc(new UnspscCode()); // Assuming Unspsc has a default constructor
        }
        Integer createdBy = 3856;
        String createdByToolId = "testToolId";
        String realmId = "testRealmId";
        when(cropRepository.save(any(Crop.class))).thenReturn(crop);

        Crop savedCrop = cropService.saveCrop(crop, realmId, createdBy, createdByToolId);

        verify(cropRepository).save(crop);
        assertEquals(createdBy, savedCrop.getCreatedBy());
        assertEquals(createdByToolId, savedCrop.getCreatedByToolId());
    }

    /** Tests getCropById method to ensure it returns a crop when found. */
    @Test
    void getCropByIdFound() {
        Integer cropId = 1;
        Integer userId = 3856;
        String toolId = "testToolId";
        String realmId = "testRealmId";
        Crop crop = new Crop(); // Initialize with test data
        if (crop.getEppocode() == null) {
            crop.setEppocode(new EppoCode()); // Assuming EppoCode has a default constructor
        }
        if (crop.getUnspsc() == null) {
            crop.setUnspsc(new UnspscCode()); // Assuming Unspsc has a default constructor
        }
        when(cropRepository.findById(cropId)).thenReturn(Optional.of(crop));

        Optional<Crop> result = cropService.getCropById(realmId, userId, toolId, cropId);

        assertTrue(result.isPresent());
        assertEquals(crop, result.get());
    }

    /** Tests getCropById method to ensure it handles cases where a crop is not found. */
    @Test
    void getCropByIdNotFound() {
        Integer cropId = 1;
        Integer userId = 3856;
        String toolId = "testToolId";
        String realmId = "testRealmId";
        when(cropRepository.findById(cropId)).thenReturn(Optional.empty());

        Optional<Crop> result = cropService.getCropById(realmId, userId, toolId, cropId);

        assertFalse(result.isPresent());
    }

    //    /**
    //     * Tests getAllCrops method to ensure it returns all crops.
    //     */
    //    @Test
    //    void getAllCrops() {
    //        List<Crop> crops = List.of(new Crop(), new Crop()); // Initialize with test data
    //        when(cropRepository.findAll()).thenReturn(crops);
    //
    //        List<Crop> result = cropService.getAllCrops();
    //
    //        assertEquals(crops.size(), result.size());
    //    }

    /** Tests deleteCrop method to ensure it correctly deletes a crop. */
    @Test
    void deleteCrop() {
        Integer cropId = 1;
        doNothing().when(cropRepository).deleteById(cropId);

        cropService.deleteCrop(cropId);

        verify(cropRepository).deleteById(cropId);
    }

    /** Tests updateCrop method to ensure it updates a crop correctly when found. */
    @Test
    void updateCrop() {
        Integer cropId = 1;
        Crop crop = new Crop(); // Initialize with test data
        Integer updatedBy = 3856;
        String updatedByToolId = "testToolIdUpdate";

        Crop updatedCrop = new Crop();
        updatedCrop.setUpdatedBy(updatedBy);
        updatedCrop.setUpdatedByToolId(updatedByToolId);

        when(cropRepository.findById(cropId)).thenReturn(Optional.of(crop));
        when(cropRepository.save(any(Crop.class))).thenReturn(updatedCrop);

        Crop result = cropService.updateCrop(cropId, new Crop(), updatedBy, updatedByToolId);

        assertNotNull(result);
        assertEquals(updatedBy, result.getUpdatedBy());
        assertEquals(updatedByToolId, result.getUpdatedByToolId());
        verify(cropRepository).save(any(Crop.class));
    }

    /** Tests updateCrop method to ensure it throws an exception when the crop is not found. */
    @Test
    void updateCropNotFound() {
        Integer cropId = 1;
        Integer updatedBy = 3856;
        String updatedByToolId = "testToolIdUpdate";

        when(cropRepository.findById(cropId)).thenReturn(Optional.empty());

        Exception exception =
                assertThrows(
                        RuntimeException.class,
                        () -> {
                            cropService.updateCrop(cropId, new Crop(), updatedBy, updatedByToolId);
                        });

        String expectedMessage = "Crop not found for this id :: " + cropId;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void udiSearch() throws IOException {

        // Mocking the SearchResponse and ElasticsearchClient
        SearchResponse<Map> mockResponse = mock(SearchResponse.class);
        when(elasticsearchClient.search(any(Function.class), eq(Map.class))).thenReturn(mockResponse);

        // Execute the service method
        SearchResponse<Map> response = cropService.udiSearch();

        // Assertions and verifications
        assertNotNull(response);
        verify(elasticsearchClient).search(any(Function.class), eq(Map.class));
    }

    @Test
    void udiSearch_InvalidElasticsearchClientResponse_Null() throws IOException {
        when(elasticsearchClient.search(any(Function.class), eq(Map.class))).thenReturn(null);

        SearchResponse<Map> resultResponse = cropService.udiSearch();

        assertNull(resultResponse);
    }


    @Test
    void udiSearch_EmptyResponse() throws IOException {
        // Create mock objects
        SearchResponse<Map> mockResponse = mock(SearchResponse.class);
        HitsMetadata<Map> hitsMetadata = mock(HitsMetadata.class);

        // Stub the hits() method to return the mock HitsMetadata
        when(mockResponse.hits()).thenReturn(hitsMetadata);

        // Stub the hits() method of HitsMetadata to return an empty list of hits
        when(hitsMetadata.hits()).thenReturn(Collections.emptyList());

        // Mock ElasticsearchClient behavior to return the mock response
        when(elasticsearchClient.search(any(Function.class), eq(Map.class))).thenReturn(mockResponse);

        // Perform the search operation
        SearchResponse<Map> resultResponse = cropService.udiSearch();

        // Assertions to ensure that the result response indicates no results
        assertNotNull(resultResponse);
        assertTrue(resultResponse.hits().hits().isEmpty());
    }

    //    @Test
    //    void udiSearch_EmptyResponse() throws IOException {
    //
    //        SearchResponse<Map> mockResponse = mock(SearchResponse.class);
    //
    //        HitsMetadata<Map> hitsMetadata = mock(HitsMetadata.class);
    //        when(hitsMetadata.hits()).thenReturn(Collections.emptyList());
    //
    //        when(mockResponse.hits()).thenReturn(hitsMetadata);
    //
    //        when(elasticsearchClient.search(any(Function.class),
    // eq(Map.class))).thenReturn(mockResponse);
    //
    //        SearchResponse<Map> resultResponse = cropService.udiSearch();
    //
    //        assertNotNull(resultResponse);
    //        assertTrue(resultResponse.hits().hits().isEmpty());
    //    }

    @Test
    void findAllCrops() {
        Integer userId = 3856;
        String toolId = "testToolId";
        String realmId = "testRealmId";
        Pageable pageable = Pageable.unpaged();
        Sort sort = Sort.by(Sort.Direction.ASC, "name"); // Example sort criteria
        Page<Crop> expectedPage = mock(Page.class); // Mocking the expected Page<Crop> response
        when(cropRepo.getAllCrops(any(Pageable.class), any(Sort.class))).thenReturn(expectedPage);

        Page<Crop> resultPage = cropService.findAllCrops(realmId, userId, toolId, pageable, sort);

        assertEquals(expectedPage, resultPage);
        verify(cropRepo).getAllCrops(pageable, sort); // Verify with both pageable and sort
    }

    @Test
    void getCropWithRSQLFilter() {

        Integer userId = 3856;
        String toolId = "testToolId";
        String realmId = "testRealmId";
        Condition condition = mock(Condition.class); // Mocking the expected jOOQ Condition
        Pageable pageable = Pageable.unpaged(); // Creating an unpaged Pageable
        Sort sort = Sort.by(Sort.Direction.ASC, "name"); // Example sort criteria
        Crop crop1 = new Crop();
        Crop crop2 = new Crop();
        List<Crop> expectedList = List.of(crop1, crop2);
        if (crop1.getEppocode() == null || crop2.getEppocode() == null) {
            crop1.setEppocode(new EppoCode()); // Assuming EppoCode has a default constructor
            crop2.setEppocode(new EppoCode());
        }
        if (crop1.getUnspsc() == null || crop2.getUnspsc() == null) {
            crop1.setUnspsc(new UnspscCode()); // Assuming Unspsc has a default constructor
            crop2.setUnspsc(new UnspscCode());
        }
        Page<Crop> expectedPage =
                new PageImpl<>(expectedList); // Mocking the expected Page<Crop> response
        when(cropRepo.getAllCropsWithSqlCondition(
                any(Condition.class), any(Pageable.class), any(Sort.class)))
                .thenReturn(expectedPage);

        Page<Crop> resultList =
                cropService.getCropWithRSQLFilter(realmId, userId, toolId, condition, pageable, sort);

        assertEquals(expectedPage, resultList);
        verify(cropRepo).getAllCropsWithSqlCondition(condition, pageable, sort);
    }
}