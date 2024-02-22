package com.ninjacart.agri.advisory.pesticide.repository;

import com.ninjacart.agri.advisory.pesticide.models.Pesticide;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Pesticide entity.
 * This interface extends JpaRepository, providing CRUD operations and more
 * for Pesticide entities without the need for boilerplate code.
 */
public interface PesticideRepository extends JpaRepository<Pesticide, Integer> {
    // Additional custom queries specific to Pesticide can be defined here if needed.
}
