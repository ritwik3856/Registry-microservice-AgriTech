package com.ninjacart.agri.advisory.refdata.repository;

import com.ninjacart.agri.advisory.refdata.models.AgriStackCrop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgriStackCropRepository extends JpaRepository<AgriStackCrop, Integer> {

}
