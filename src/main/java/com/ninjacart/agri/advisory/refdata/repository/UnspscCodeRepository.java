package com.ninjacart.agri.advisory.refdata.repository;

import com.ninjacart.agri.advisory.refdata.models.UnspscCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnspscCodeRepository extends JpaRepository<UnspscCode, Integer> {
}
