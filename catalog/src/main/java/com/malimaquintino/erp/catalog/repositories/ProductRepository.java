package com.malimaquintino.erp.catalog.repositories;

import com.malimaquintino.erp.catalog.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Set;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    Set<Product> findByIdIn(List<Long> idList);
}
