package com.realEstate.controller;

import com.realEstate.dto.InquiryRequest;
import com.realEstate.entity.Inquiry;
import com.realEstate.service.InquiryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inquiries")
public class InquiryController {

    private final InquiryService inquiryService;

    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    // POST /api/inquiries -> Sends an inquiry to the property owner
    @PostMapping
    public ResponseEntity<Inquiry> sendInquiry(@RequestBody InquiryRequest inquiryRequest) {
        Inquiry inquiry = inquiryService.sendInquiry(
                inquiryRequest.getPropertyId(),
                inquiryRequest.getUserId(),
                inquiryRequest.getMessage()
        );
        return new ResponseEntity<>(inquiry, HttpStatus.CREATED);  // Return 201 Created
    }

    // GET /api/inquiries -> Fetches all inquiries for a specific property
    @GetMapping
    public ResponseEntity<List<Inquiry>> getInquiriesForProperty(@RequestParam Long propertyId) {
        List<Inquiry> inquiries = inquiryService.getInquiriesForProperty(propertyId);
        if (inquiries.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Return 204 No Content if no inquiries found
        }
        return new ResponseEntity<>(inquiries, HttpStatus.OK);  // Return 200 OK with inquiries
    }
}
