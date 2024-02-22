package com.ninjacart.agri.advisory.seed.repository;

import com.ninjacart.agri.advisory.seed.models.Seed;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Seed entity.
 * This interface extends JpaRepository, providing CRUD operations and more
 * for Seed entities without the need for boilerplate code.
 */
public interface SeedRepository extends JpaRepository<Seed, Integer> {
    // Additional custom queries specific to Seed can be defined here if needed.
}
