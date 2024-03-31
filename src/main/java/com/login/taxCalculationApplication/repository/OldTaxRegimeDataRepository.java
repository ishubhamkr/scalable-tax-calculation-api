package com.login.taxCalculationApplication.repository;

import com.login.taxCalculationApplication.entity.OldTaxRegimeData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OldTaxRegimeDataRepository extends MongoRepository<OldTaxRegimeData, String> {
}
