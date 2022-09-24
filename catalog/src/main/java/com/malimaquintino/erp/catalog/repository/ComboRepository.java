package com.malimaquintino.erp.catalog.repository;

import com.malimaquintino.erp.catalog.models.Combo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ComboRepository extends JpaRepository<Combo, Long>, JpaSpecificationExecutor<Combo> {
}
