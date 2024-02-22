package com.ninjacart.agri.advisory.fertilizer.service;

import com.ninjacart.agri.advisory.fertilizer.event.FertilizerCreatedEvent;
import com.ninjacart.agri.advisory.fertilizer.models.Fertilizer;
import com.ninjacart.agri.advisory.fertilizer.repository.FertilizerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing operations related to Fertilizer entities.
 * This includes saving, retrieving, deleting, and updating fertilizers.
 */
@Service
public class FertilizerService {

    private final FertilizerRepository fertilizerRepository;
    private final ApplicationEventPublisher eventPublisher;

    /**
     * Constructs the FertilizerService with required dependencies.
     *
     * @param fertilizerRepository  Repository for CRUD operations on Fertilizer entities
     * @param eventPublisher  Event publisher to publish fertilizer-related events
     */

    @Autowired
    public FertilizerService(FertilizerRepository fertilizerRepository, ApplicationEventPublisher eventPublisher) {
        this.fertilizerRepository = fertilizerRepository;
        this.eventPublisher = eventPublisher;
    }

    /**
     * Saves a fertilizer entity and publishes a FertilizerCreatedEvent.
     *
     * @param fertilizer The Fertilizer entity to be saved
     * @return The saved Fertilizer entity
     */
    public Fertilizer saveFertilizer(Fertilizer fertilizer, Integer createdBy, String createdByToolId) {
        fertilizer.setCreatedAt(LocalDateTime.now());
        fertilizer.setUpdatedAt(LocalDateTime.now());
        fertilizer.setCreatedBy(createdBy);
        fertilizer.setCreatedByToolId(createdByToolId);

        Fertilizer savedFertilizer = fertilizerRepository.save(fertilizer);
        eventPublisher.publishEvent(new FertilizerCreatedEvent(this, savedFertilizer.getId()));
        return savedFertilizer;
    }

    /**
     * Retrieves a fertilizer by its ID.
     *
     * @param id The ID of the Fertilizer to retrieve
     * @return An Optional containing the found Fertilizer or empty if not found
     */
    public Optional<Fertilizer> getFertilizerById(Integer id) {
        return fertilizerRepository.findById(id);
    }

    /**
     * Retrieves all fertilizer entities.
     *
     * @return A List of all Fertilizer entities
     */
    public List<Fertilizer> getAllFertilizers() {
        return fertilizerRepository.findAll();
    }

    /**
     * Deletes a fertilizer entity based on its ID.
     *
     * @param id The ID of the Fertilizer to delete
     */
    public void deleteFertilizer(Integer id) {
        fertilizerRepository.deleteById(id);
    }

    /**
     * Updates a fertilizer entity. Ignores certain unmodifiable fields like 'id'.
     *
     * @param id          The ID of the Fertilizer to update
     * @param fertilizerDetails Fertilizer object containing updated fields
     * @return The updated Fertilizer entity
     * @throws RuntimeException if the fertilizer with the specified ID is not found
     */
    public Fertilizer updateFertilizer(Integer id, Fertilizer fertilizerDetails, Integer updatedBy, String updatedByToolId) {
        Fertilizer existingFertilizer = fertilizerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fertilizer not found for this id :: " + id));

        existingFertilizer.setUpdatedAt(LocalDateTime.now());
        existingFertilizer.setUpdatedBy(updatedBy);
        existingFertilizer.setUpdatedByToolId(updatedByToolId);

        BeanUtils.copyProperties(fertilizerDetails, existingFertilizer, "id", "createdBy", "createdAt", "createdByToolId");
        return fertilizerRepository.save(existingFertilizer);
    }

}
