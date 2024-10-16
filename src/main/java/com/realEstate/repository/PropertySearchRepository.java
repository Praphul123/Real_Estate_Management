package com.realEstate.repository;

import com.realEstate.entity.PropertySearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertySearchRepository extends JpaRepository<PropertySearch, Long>, JpaSpecificationExecutor<PropertySearch> {
    // JpaSpecificationExecutor allows custom search and filtering using Specification
}

