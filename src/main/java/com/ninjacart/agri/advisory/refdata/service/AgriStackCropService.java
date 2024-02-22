package com.ninjacart.agri.advisory.refdata.service;

import com.ninjacart.agri.advisory.refdata.models.AgriStackCrop;
import com.ninjacart.agri.advisory.refdata.repository.AgriStackCropRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;

/** Service class for managing operations related to EPPO Code entities. */
@Service
public class AgriStackCropService {

    private final AgriStackCropRepository agriStackCropRepository;

    @Autowired
    public AgriStackCropService(AgriStackCropRepository agriStackCropRepository) {
        this.agriStackCropRepository = agriStackCropRepository;
    }

    /**
     * Saves an EPPO code entity.
     *
     * @param agriStackCrop The EPPO Code entity to be saved.
     * @return The saved EPPO Code entity.
     */
    public AgriStackCrop saveAgriStackCrop(
            AgriStackCrop agriStackCrop, Integer createdBy, String createdByToolId, String realmId) {
        agriStackCrop.setCreatedAt(LocalDateTime.now());
        agriStackCrop.setCreatedBy(createdBy);
        agriStackCrop.setCreatedByToolId(createdByToolId);
        agriStackCrop.setRealmId(realmId);
        return agriStackCropRepository.save(agriStackCrop);
    }

    /**
     * Retrieves an EPPO code by its ID.
     *
     * @param id The ID of the EPPO Code to retrieve.
     * @return An Optional containing the found EPPO Code or empty if not found.
     */
    public Optional<AgriStackCrop> getAgriStackCropById(Integer id) {
        return agriStackCropRepository.findById(id);
    }

    /**
     * Retrieves all EPPO code entities with pagination.
     *
     * @param pageable Pagination and sorting information.
     * @return A Page of EPPO Code entities.
     */
    public Page<AgriStackCrop> getAllAgriStackCrops(Pageable pageable) {
        return agriStackCropRepository.findAll(pageable);
    }

    /**
     * Deletes an EPPO code entity based on its ID.
     *
     * @param id The ID of the EPPO Code to delete.
     */
    public void deleteAgriStackCrop(Integer id) {
        agriStackCropRepository.deleteById(id);
    }

    /**
     * Updates an existing EPPO code entity while ignoring certain unmodifiable fields.
     *
     * @param id The ID of the EPPO Code to update.
     * @param agriStackCropDetails EPPO Code object containing updated fields.
     * @return The updated EPPO Code entity.
     * @throws RuntimeException if the EPPO code with the specified ID is not found.
     */
    public AgriStackCrop updateAgriStackCrop(
            Integer id, AgriStackCrop agriStackCropDetails, Integer updatedBy, String updatedByToolId, String realmId) {
        AgriStackCrop existingAgriStackCrop =
                agriStackCropRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("AgriStackCrop not found for this id :: " + id));

        existingAgriStackCrop.setUpdatedAt(LocalDateTime.now());
        existingAgriStackCrop.setUpdatedBy(updatedBy);
        existingAgriStackCrop.setUpdatedByToolId(updatedByToolId);
        existingAgriStackCrop.setRealmId(realmId);

        // Update modifiable fields
        BeanUtils.copyProperties(
                agriStackCropDetails, existingAgriStackCrop, "id", "createdBy", "createdAt", "createdByToolId");

        return agriStackCropRepository.save(existingAgriStackCrop);
    }
}
