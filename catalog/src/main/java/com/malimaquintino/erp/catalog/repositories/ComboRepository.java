package com.malimaquintino.erp.catalog.repositories;

import com.malimaquintino.erp.catalog.models.Combo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ComboRepository extends JpaRepository<Combo, Long>, JpaSpecificationExecutor<Combo> {
}
