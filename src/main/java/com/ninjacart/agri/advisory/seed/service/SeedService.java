package com.ninjacart.agri.advisory.seed.service;

import com.ninjacart.agri.advisory.seed.models.Seed;
import com.ninjacart.agri.advisory.seed.repository.SeedRepository;
import com.ninjacart.agri.advisory.seed.event.SeedCreatedEvent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing operations related to Seed entities.
 * This includes saving, retrieving, deleting, and updating seeds.
 */
@Service
public class SeedService {

    private final SeedRepository seedRepository;
    private final ApplicationEventPublisher eventPublisher;

    /**
     * Constructs the SeedService with required dependencies.
     *
     * @param seedRepository  Repository for CRUD operations on Seed entities
     * @param eventPublisher  Event publisher to publish seed-related events
     */

    @Autowired
    public SeedService(SeedRepository seedRepository, ApplicationEventPublisher eventPublisher) {
        this.seedRepository = seedRepository;
        this.eventPublisher = eventPublisher;
    }

    /**
     * Saves a seed entity and publishes a SeedCreatedEvent.
     *
     * @param seed The Seed entity to be saved
     * @return The saved Seed entity
     */
    public Seed saveSeed(Seed seed, Integer createdBy, String createdByToolId) {
        seed.setCreatedAt(LocalDateTime.now());
        seed.setUpdatedAt(LocalDateTime.now());
        seed.setCreatedBy(createdBy);
        seed.setCreatedByToolId(createdByToolId);

        Seed savedSeed = seedRepository.save(seed);
        eventPublisher.publishEvent(new SeedCreatedEvent(this, savedSeed.getId()));
        return savedSeed;
    }

    /**
     * Retrieves a seed by its ID.
     *
     * @param id The ID of the Seed to retrieve
     * @return An Optional containing the found Seed or empty if not found
     */
    public Optional<Seed> getSeedById(Integer id) {
        return seedRepository.findById(id);
    }

    /**
     * Retrieves all seed entities.
     *
     * @return A List of all Seed entities
     */
    public List<Seed> getAllSeeds() {
        return seedRepository.findAll();
    }

    /**
     * Deletes a seed entity based on its ID.
     *
     * @param id The ID of the Seed to delete
     */
    public void deleteSeed(Integer id) {
        seedRepository.deleteById(id);
    }

    /**
     * Updates a seed entity. Ignores certain unmodifiable fields like 'id'.
     *
     * @param id          The ID of the Seed to update
     * @param seedDetails Seed object containing updated fields
     * @return The updated Seed entity
     * @throws RuntimeException if the seed with the specified ID is not found
     */
    public Seed updateSeed(Integer id, Seed seedDetails, Integer updatedBy, String updatedByToolId) {
        Seed existingSeed = seedRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seed not found for this id :: " + id));
        existingSeed.setUpdatedAt(LocalDateTime.now());
        existingSeed.setUpdatedBy(updatedBy);
        existingSeed.setUpdatedByToolId(updatedByToolId);

        BeanUtils.copyProperties(seedDetails, existingSeed, "id", "createdBy", "createdAt", "createdByToolId");
        return seedRepository.save(existingSeed);
    }
}
