package com.malimaquintino.erp.financial.repository;

import com.malimaquintino.erp.financial.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long>, JpaSpecificationExecutor<Bill> {
    Optional<Bill> findByCustomerDocumentAndDueDate(String customerDocument, LocalDate dueDate);
}
