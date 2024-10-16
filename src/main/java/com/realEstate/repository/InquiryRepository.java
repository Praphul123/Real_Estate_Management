package com.realEstate.repository;

import com.realEstate.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {

    // Method to fetch all inquiries for a specific property
    List<Inquiry> findByPropertyId(Long propertyId);
}

