package com.ninjacart.agri.advisory.refdata.repository;

import com.ninjacart.agri.advisory.refdata.models.EppoCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EppoCodeRepository extends JpaRepository<EppoCode, Integer> {
}
