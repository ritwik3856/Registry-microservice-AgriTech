package com.ninjacart.agri.advisory.crop.repository;

import com.ninjacart.agri.advisory.crop.models.CropDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropDetailsRepository extends JpaRepository<CropDetails, Integer> {
    // Additional custom queries specific to Crop can be defined here if needed.
}
