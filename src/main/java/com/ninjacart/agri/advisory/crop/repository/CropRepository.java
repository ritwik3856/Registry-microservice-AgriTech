package com.ninjacart.agri.advisory.crop.repository;

import com.ninjacart.agri.advisory.crop.models.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Crop entity.
 * This interface extends JpaRepository, providing CRUD operations and more
 * for Crop entities without the need for boilerplate code.
 */
@Repository
public interface CropRepository extends JpaRepository<Crop, Integer> {
    // Additional custom queries specific to Crop can be defined here if needed.
}

