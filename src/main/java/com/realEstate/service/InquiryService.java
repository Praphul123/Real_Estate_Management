package com.realEstate.service;

import com.realEstate.entity.Inquiry;
import com.realEstate.entity.Property;
import com.realEstate.entity.User;
import com.realEstate.repository.InquiryRepository;
import com.realEstate.repository.PropertyRepository;
import com.realEstate.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryService {

    private final InquiryRepository inquiryRepository;
    private final PropertyRepository propertyRepository;
    private final UserRepository userRepository;

    public InquiryService(InquiryRepository inquiryRepository, PropertyRepository propertyRepository, UserRepository userRepository) {
        this.inquiryRepository = inquiryRepository;
        this.propertyRepository = propertyRepository;
        this.userRepository = userRepository;
    }

    public Inquiry sendInquiry(Long propertyId, Long userId, String message) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Inquiry inquiry = new Inquiry();
        inquiry.setProperty(property);
        inquiry.setUser(user);
        inquiry.setMessage(message);

        return inquiryRepository.save(inquiry);
    }

    public List<Inquiry> getInquiriesForProperty(Long propertyId) {
        return inquiryRepository.findByPropertyId(propertyId);
    }
}
