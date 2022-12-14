package com.malimaquintino.erp.customer.repository;


import com.malimaquintino.erp.customer.models.ContractProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractProductRepository extends JpaRepository<ContractProduct, Long>, JpaSpecificationExecutor<ContractProduct> {
}
