package com.ninjacart.agri.advisory.pesticide.service;

import com.ninjacart.agri.advisory.pesticide.event.PesticideCreatedEvent;
import com.ninjacart.agri.advisory.pesticide.models.Pesticide;
import com.ninjacart.agri.advisory.pesticide.repository.PesticideRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing operations related to Pesticide entities.
 * This includes saving, retrieving, deleting, and updating pesticides.
 */
@Service
public class PesticideService {

    private final PesticideRepository pesticideRepository;
    private final ApplicationEventPublisher eventPublisher;

    /**
     * Constructs the PesticideService with required dependencies.
     *
     * @param pesticideRepository  Repository for CRUD operations on Pesticide entities
     * @param eventPublisher  Event publisher to publish pesticide-related events
     */

    @Autowired
    public PesticideService(PesticideRepository pesticideRepository, ApplicationEventPublisher eventPublisher) {
        this.pesticideRepository = pesticideRepository;
        this.eventPublisher = eventPublisher;
    }

    /**
     * Saves a pesticide entity and publishes a PesticideCreatedEvent.
     *
     * @param pesticide The Pesticide entity to be saved
     * @return The saved Pesticide entity
     */
    public Pesticide savePesticide(Pesticide pesticide, Integer createdBy, String createdByToolId) {
        pesticide.setCreatedAt(LocalDateTime.now());
        pesticide.setUpdatedAt(LocalDateTime.now());
        pesticide.setCreatedBy(createdBy);
        pesticide.setCreatedByToolId(createdByToolId);

        Pesticide savedPesticide = pesticideRepository.save(pesticide);
        eventPublisher.publishEvent(new PesticideCreatedEvent(this, savedPesticide.getId()));
        return savedPesticide;
    }

    /**
     * Retrieves a pesticide by its ID.
     *
     * @param id The ID of the Pesticide to retrieve
     * @return An Optional containing the found Pesticide or empty if not found
     */
    public Optional<Pesticide> getPesticideById(Integer id) {
        return pesticideRepository.findById(id);
    }

    /**
     * Retrieves all pesticide entities.
     *
     * @return A List of all Pesticide entities
     */
    public List<Pesticide> getAllPesticides() {
        return pesticideRepository.findAll();
    }

    /**
     * Deletes a pesticide entity based on its ID.
     *
     * @param id The ID of the Pesticide to delete
     */
    public void deletePesticide(Integer id) {
        pesticideRepository.deleteById(id);
    }

    /**
     * Updates a pesticide entity. Ignores certain unmodifiable fields like 'id'.
     *
     * @param id          The ID of the Pesticide to update
     * @param pesticideDetails Pesticide object containing updated fields
     * @return The updated Pesticide entity
     * @throws RuntimeException if the pesticide with the specified ID is not found
     */
    public Pesticide updatePesticide(Integer id, Pesticide pesticideDetails, Integer updatedBy, String updatedByToolId){
        Pesticide existingPesticide = pesticideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pesticide not found for this id :: " + id));

        existingPesticide.setUpdatedAt(LocalDateTime.now());
        existingPesticide.setUpdatedBy(updatedBy);
        existingPesticide.setUpdatedByToolId(updatedByToolId);

        BeanUtils.copyProperties(pesticideDetails, existingPesticide, "id", "createdBy", "createdAt", "createdByToolId");
        return pesticideRepository.save(existingPesticide);
    }
}
