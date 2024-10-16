package com.realEstate.repository;

import com.realEstate.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Additional query methods can be defined here
    List<Review> findByPropertyId(Long propertyId);
    List<Review> findByAgentId(Long agentId);
}