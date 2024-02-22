package com.ninjacart.agri.advisory.crop.service;

import com.ninjacart.agri.advisory.crop.models.CropDetails;
import com.ninjacart.agri.advisory.crop.repository.CropDetailsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CropDetailsService {

    private final CropDetailsRepository cropDetailsRepository;

    @Autowired
    public CropDetailsService(CropDetailsRepository cropDetailsRepository) {
        this.cropDetailsRepository = cropDetailsRepository;
    }

    /**
     * Saves an EPPO code entity.
     *
     * @param cropDetails The EPPO Code entity to be saved.
     * @return The saved EPPO Code entity.
     */
    public CropDetails saveCropDetails(
            CropDetails cropDetails, Integer createdBy, String createdByToolId, String realmId) {
        cropDetails.setCreatedAt(LocalDateTime.now());
        cropDetails.setCreatedBy(createdBy);
        cropDetails.setCreatedByToolId(createdByToolId);
        cropDetails.setRealmId(realmId);
        return cropDetailsRepository.save(cropDetails);
    }

    /**
     * Retrieves an EPPO code by its ID.
     *
     * @param id The ID of the EPPO Code to retrieve.
     * @return An Optional containing the found EPPO Code or empty if not found.
     */
    public Optional<CropDetails> getCropDetailsById(Integer id) {
        return cropDetailsRepository.findById(id);
    }

    /**
     * Retrieves all EPPO code entities with pagination.
     *
     * @param pageable Pagination and sorting information.
     * @return A Page of EPPO Code entities.
     */
    public Page<CropDetails> getAllCropDetails(Pageable pageable) {
        return cropDetailsRepository.findAll(pageable);
    }

    /**
     * Deletes an EPPO code entity based on its ID.
     *
     * @param id The ID of the EPPO Code to delete.
     */
    public void deleteCropDetails(Integer id) {
        cropDetailsRepository.deleteById(id);
    }

    /**
     * Updates an existing EPPO code entity while ignoring certain unmodifiable fields.
     *
     * @param id The ID of the EPPO Code to update.
     * @param cropDetailsdetails EPPO Code object containing updated fields.
     * @return The updated EPPO Code entity.
     * @throws RuntimeException if the EPPO code with the specified ID is not found.
     */
    public CropDetails updateCropDetails(
            Integer id, CropDetails cropDetailsdetails, Integer updatedBy, String updatedByToolId, String realmId) {
        CropDetails existingCropDetails =
                cropDetailsRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Crop Details not found for this id :: " + id));

        existingCropDetails.setUpdatedAt(LocalDateTime.now());
        existingCropDetails.setUpdatedBy(updatedBy);
        existingCropDetails.setUpdatedByToolId(updatedByToolId);
        existingCropDetails.setRealmId(realmId);

        BeanUtils.copyProperties(
                cropDetailsdetails, existingCropDetails, "id", "createdBy", "createdAt", "createdByToolId");

        return cropDetailsRepository.save(existingCropDetails);
    }

}
