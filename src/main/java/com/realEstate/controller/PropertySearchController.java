package com.realEstate.controller;

import com.realEstate.dto.PropertySearchRequest;
import com.realEstate.entity.PropertySearch;
import com.realEstate.service.PropertySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable; // Correct import
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/property-search")
public class PropertySearchController {

    private final PropertySearchService propertySearchService;

    @Autowired
    public PropertySearchController(PropertySearchService propertySearchService) {
        this.propertySearchService = propertySearchService;
    }

    @PostMapping("/search")
    public ResponseEntity<Page<PropertySearch>> searchProperties(
            @RequestBody PropertySearchRequest searchRequest,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "ASC") String sortDirection) {

        // Correct Pageable creation with sorting
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        // Use propertySearchService instead of propertyService
        Page<PropertySearch> properties = propertySearchService.searchProperties(
                searchRequest, pageable
        );

        return ResponseEntity.ok(properties);
    }
}
