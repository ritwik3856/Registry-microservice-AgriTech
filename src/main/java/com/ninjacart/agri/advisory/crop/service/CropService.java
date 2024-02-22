package com.ninjacart.agri.advisory.crop.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.ninjacart.agri.advisory.crop.event.CropCreatedEvent;
import com.ninjacart.agri.advisory.crop.models.Crop;
import com.ninjacart.agri.advisory.crop.repository.CropRepository;
import com.ninjacart.agri.advisory.crop.repository.CropRepo;
//import com.ninjacart.agri.advisory.crop.util.ElasticSearchUtil;
import com.ninjacart.agri.advisory.crop.util.ElasticSearchUtil;
import com.ninjacart.agri.advisory.refdata.api.EppoCodeController;
import com.ninjacart.agri.advisory.refdata.api.UnspscCodeController;
import org.jooq.Condition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Service class for managing operations related to Crop entities.
 * This includes saving, retrieving, deleting, and updating crops.
 */
@Service
public class CropService {

    private final ElasticsearchClient elasticsearchClient;
    private final CropRepository cropRepository;
    private final CropRepo cropRepo;

    private final ApplicationEventPublisher eventPublisher;

    /**
     * Constructs the CropService with required dependencies.
     *
     * @param cropRepository  Repository for CRUD operations on Crop entities
     * @param eventPublisher  Event publisher to publish crop-related events
     */

    @Autowired
    public CropService(CropRepository cropRepository, CropRepo cropRepo, ApplicationEventPublisher eventPublisher, ElasticsearchClient elasticsearchClient) {
        this.cropRepository = cropRepository;
        this.cropRepo = cropRepo;
        this.eventPublisher = eventPublisher;
        this.elasticsearchClient=elasticsearchClient;
    }

    /**
     * Saves a crop entity and publishes a CropCreatedEvent.
     *
     * @param crop The Crop entity to be saved
     * @return The saved Crop entity
     */
    public Crop saveCrop(Crop crop, String realmId , Integer createdBy, String createdByToolId) {
        crop.setCreatedAt(LocalDateTime.now());
        crop.setCreatedBy(createdBy);
        crop.setCreatedByToolId(createdByToolId);
        crop.setRealmId(realmId);

        crop.getEppocode().setRealmId(realmId);
        crop.getEppocode().setCreatedBy(createdBy);
        crop.getEppocode().setCreatedByToolId(createdByToolId);
        crop.getEppocode().setCreatedAt(LocalDateTime.now());

        crop.getUnspsc().setRealmId(realmId);
        crop.getUnspsc().setCreatedBy(createdBy);
        crop.getUnspsc().setCreatedByToolId(createdByToolId);
        crop.getUnspsc().setCreatedAt(LocalDateTime.now());

        Crop savedCrop = cropRepository.save(crop);
        eventPublisher.publishEvent(new CropCreatedEvent(this, savedCrop.getId(), savedCrop));
        return savedCrop;
    }

    /**
     * Retrieves a crop by its ID.
     *
     * @param id The ID of the Crop to retrieve
     * @return An Optional containing the found Crop or empty if not found
     */
    public Optional<Crop> getCropById(String realmId, Integer userId, String toolID , Integer id) {

        Optional<Crop> cropOpt = cropRepository.findById(id);
        if (cropOpt.isPresent()) {

            Crop crop = cropOpt.get();
            Integer eppocode = crop.getEppocode().getId();
            Integer unspsc = crop.getUnspsc().getId();

            crop.add(linkTo(methodOn(EppoCodeController.class).getEppoCodeById(realmId , userId , toolID , eppocode)).withRel("EPPO Code"));
            crop.add(linkTo(methodOn(UnspscCodeController.class).getUnspscCodeById(realmId , userId , toolID , unspsc)).withRel("UNSPSC Code"));

            return Optional.of(crop);
        }
        return Optional.empty();
    }

    /**
     * Retrieves all crop entities.
     *
     * @return A List of all Crop entities
     */
//    public List<Crop> getAllCrops() {
//        return cropRepository.findAll();
//    }

    /**
     * Deletes a crop entity based on its ID.
     *
     * @param id The ID of the Crop to delete
     */
    public void deleteCrop(Integer id) {
        cropRepository.deleteById(id);
    }

    /**
     * Updates a crop entity. Ignores certain unmodifiable fields like 'id'.
     *
     * @param id          The ID of the Crop to update
     * @param cropDetails Crop object containing updated fields
     * @return The updated Crop entity
     * @throws RuntimeException if the crop with the specified ID is not found
     */
    public Crop updateCrop(Integer id, Crop cropDetails, Integer updatedBy, String updatedByToolId) {
        Crop existingCrop = cropRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Crop not found for this id :: " + id));

        existingCrop.setUpdatedAt(LocalDateTime.now());
        existingCrop.setUpdatedBy(updatedBy);
        existingCrop.setUpdatedByToolId(updatedByToolId);

        BeanUtils.copyProperties(cropDetails, existingCrop, "id", "createdBy", "createdAt", "createdByToolId");
        eventPublisher.publishEvent(new CropCreatedEvent(this, existingCrop.getId(), existingCrop));
        return cropRepository.save(existingCrop);
    }

    public SearchResponse<Map> udiSearch() throws IOException {

        Supplier<Query> supplier = ElasticSearchUtil.supplierExistsQuery(Crop.class);
        System.out.println(supplier.get().toString());
        SearchResponse<Map> searchResponse = elasticsearchClient.search(s -> s.index("crop").query(supplier.get()), Map.class);
        return searchResponse;
    }

    public Page<Crop> findAllCrops(String realmId, Integer userId, String toolID , Pageable pageable, Sort sort) {

        Page<Crop> crop = cropRepo.getAllCrops(pageable, sort);

//        List<Crop> crops = crop.getContent();

//        for(Crop crp : crops){
//
//            Integer eppo_id = crp.getEppocode().getId();
//            Integer unspsc_id = crp.getUnspsc().getId();
//            crp.add(linkTo(methodOn(EppoCodeController.class).getEppoCodeById(realmId , userId , toolID , eppo_id)).withRel("EPPO-Code"));
//            crp.add(linkTo(methodOn(UnspscCodeController.class).getUnspscCodeById(realmId , userId , toolID , unspsc_id)).withRel("UNSPSC-Code"));
//        }

        return crop;
    }
    public Page<Crop> getCropWithRSQLFilter(String realmId, Integer userId, String toolID , Condition condition, Pageable pageable, Sort sort) {
        Page<Crop> crop = cropRepo.getAllCropsWithSqlCondition(condition, pageable, sort);
        return crop;
    }
}
