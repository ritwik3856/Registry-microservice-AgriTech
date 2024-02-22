package com.ninjacart.agri.advisory.fertilizer.repository;

import com.ninjacart.agri.advisory.fertilizer.models.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Fertilizer entity.
 * This interface extends JpaRepository, providing CRUD operations and more
 * for Fertilizer entities without the need for boilerplate code.
 */
@Repository
public interface FertilizerRepository extends JpaRepository<Fertilizer, Integer> {
    // Additional custom queries specific to Fertilizer can be defined here if needed.
}
