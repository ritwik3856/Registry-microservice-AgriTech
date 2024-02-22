package com.ninjacart.agri.advisory.refdata.service;

import com.ninjacart.agri.advisory.refdata.models.EppoCode;
import com.ninjacart.agri.advisory.refdata.repository.EppoCodeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;

/** Service class for managing operations related to EPPO Code entities. */
@Service
public class EppoCodeService {

  private final EppoCodeRepository eppoCodeRepository;

  @Autowired
  public EppoCodeService(EppoCodeRepository eppoCodeRepository) {
    this.eppoCodeRepository = eppoCodeRepository;
  }

  /**
   * Saves an EPPO code entity.
   *
   * @param eppoCode The EPPO Code entity to be saved.
   * @return The saved EPPO Code entity.
   */
  public EppoCode saveEppoCode(
          EppoCode eppoCode, Integer createdBy, String createdByToolId, String realmId) {
    eppoCode.setCreatedAt(LocalDateTime.now());
    eppoCode.setCreatedBy(createdBy);
    eppoCode.setCreatedByToolId(createdByToolId);
    eppoCode.setRealmId(realmId);
    return eppoCodeRepository.save(eppoCode);
  }

  /**
   * Retrieves an EPPO code by its ID.
   *
   * @param id The ID of the EPPO Code to retrieve.
   * @return An Optional containing the found EPPO Code or empty if not found.
   */
  public Optional<EppoCode> getEppoCodeById(Integer id) {
    return eppoCodeRepository.findById(id);
  }

  /**
   * Retrieves all EPPO code entities with pagination.
   *
   * @param pageable Pagination and sorting information.
   * @return A Page of EPPO Code entities.
   */
  public Page<EppoCode> getAllEppoCodes(Pageable pageable) {
    return eppoCodeRepository.findAll(pageable);
  }

  /**
   * Deletes an EPPO code entity based on its ID.
   *
   * @param id The ID of the EPPO Code to delete.
   */
  public void deleteEppoCode(Integer id) {
    eppoCodeRepository.deleteById(id);
  }

  /**
   * Updates an existing EPPO code entity while ignoring certain unmodifiable fields.
   *
   * @param id The ID of the EPPO Code to update.
   * @param eppoCodeDetails EPPO Code object containing updated fields.
   * @return The updated EPPO Code entity.
   * @throws RuntimeException if the EPPO code with the specified ID is not found.
   */
  public EppoCode updateEppoCode(
          Integer id, EppoCode eppoCodeDetails, Integer updatedBy, String updatedByToolId, String realmId) {
    EppoCode existingEppoCode =
        eppoCodeRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("EPPO Code not found for this id :: " + id));

    existingEppoCode.setUpdatedAt(LocalDateTime.now());
    existingEppoCode.setUpdatedBy(updatedBy);
    existingEppoCode.setUpdatedByToolId(updatedByToolId);
    existingEppoCode.setRealmId(realmId);

    // Update modifiable fields
    BeanUtils.copyProperties(
        eppoCodeDetails, existingEppoCode, "id", "createdBy", "createdAt", "createdByToolId");

    return eppoCodeRepository.save(existingEppoCode);
  }
}
