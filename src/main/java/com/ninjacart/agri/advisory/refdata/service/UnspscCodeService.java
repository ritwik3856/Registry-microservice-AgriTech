package com.ninjacart.agri.advisory.refdata.service;

import com.ninjacart.agri.advisory.refdata.models.UnspscCode;
import com.ninjacart.agri.advisory.refdata.repository.UnspscCodeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;

/** Service class for managing operations related to UNSPSC Code entities. */
@Service
public class UnspscCodeService {

  private final UnspscCodeRepository unspscCodeRepository;

  @Autowired
  public UnspscCodeService(UnspscCodeRepository unspscCodeRepository) {
    this.unspscCodeRepository = unspscCodeRepository;
  }

  /**
   * Saves a UNSPSC code entity.
   *
   * @param unspscCode The UNSPSC Code entity to be saved.
   * @return The saved UNSPSC Code entity.
   */
  public UnspscCode saveUnspscCode(
      UnspscCode unspscCode, Integer createdBy, String createdByToolId, String realmId) {
    unspscCode.setCreatedAt(LocalDateTime.now());
    unspscCode.setCreatedBy(createdBy);
    unspscCode.setCreatedByToolId(createdByToolId);
    unspscCode.setRealmId(realmId);
    return unspscCodeRepository.save(unspscCode);
  }

  /**
   * Retrieves a UNSPSC code by its ID.
   *
   * @param id The ID of the UNSPSC Code to retrieve.
   * @return An Optional containing the found UNSPSC Code or empty if not found.
   */
  public Optional<UnspscCode> getUnspscCodeById(Integer id) {
    return unspscCodeRepository.findById(id);
  }

  /**
   * Retrieves all UNSPSC code entities with pagination.
   *
   * @param pageable Pagination and sorting information.
   * @return A Page of UNSPSC Code entities.
   */
  public Page<UnspscCode> getAllUnspscCodes(Pageable pageable) {
    return unspscCodeRepository.findAll(pageable);
  }

  /**
   * Deletes a UNSPSC code entity based on its ID.
   *
   * @param id The ID of the UNSPSC Code to delete.
   */
  public void deleteUnspscCode(Integer id) {
    unspscCodeRepository.deleteById(id);
  }

  /**
   * Updates an existing UNSPSC code entity while ignoring certain unmodifiable fields.
   *
   * @param id The ID of the UNSPSC Code to update.
   * @param unspscCodeDetails UNSPSC Code object containing updated fields.
   * @return The updated UNSPSC Code entity.
   * @throws RuntimeException if the UNSPSC code with the specified ID is not found.
   */
  public UnspscCode updateUnspscCode(
          Integer id,
      UnspscCode unspscCodeDetails,
      Integer updatedBy,
      String updatedByToolId,
      String realmId) {
    UnspscCode existingUnspscCode =
        unspscCodeRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("UNSPSC Code not found for this id :: " + id));

    existingUnspscCode.setUpdatedAt(LocalDateTime.now());
    existingUnspscCode.setUpdatedBy(updatedBy);
    existingUnspscCode.setUpdatedByToolId(updatedByToolId);
    existingUnspscCode.setRealmId(realmId);

    BeanUtils.copyProperties(
        unspscCodeDetails, existingUnspscCode, "id", "createdBy", "createdAt", "createdByToolId");

    return unspscCodeRepository.save(existingUnspscCode);
  }
}
