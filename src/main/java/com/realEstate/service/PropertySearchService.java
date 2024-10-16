package com.realEstate.service;

import com.realEstate.dto.PropertySearchRequest;
import com.realEstate.entity.PropertySearch;
import com.realEstate.repository.PropertySearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PropertySearchService {

    private final PropertySearchRepository propertySearchRepository;

    @Autowired
    public PropertySearchService(PropertySearchRepository propertySearchRepository) {
        this.propertySearchRepository = propertySearchRepository;
    }

    public Page<PropertySearch> searchProperties(PropertySearchRequest searchRequest, Pageable pageable) {
        Specification<PropertySearch> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (searchRequest.getLocation() != null && !searchRequest.getLocation().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("location"), searchRequest.getLocation()));
            }


            if (searchRequest.getType() != null && !searchRequest.getType().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("type"), searchRequest.getType()));
            }

            if (searchRequest.getMinPrice() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), searchRequest.getMinPrice()));
            }

            if (searchRequest.getMaxPrice() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), searchRequest.getMaxPrice()));
            }

            if (searchRequest.getMinSize() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("size"), searchRequest.getMinSize()));
            }

            if (searchRequest.getMaxSize() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("size"), searchRequest.getMaxSize()));
            }

            if (searchRequest.getAmenities() != null && !searchRequest.getAmenities().isEmpty()) {
                for (String amenity : searchRequest.getAmenities()) {
                    predicates.add(criteriaBuilder.like(root.get("amenities"), "%" + amenity + "%"));
                }
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        return propertySearchRepository.findAll(specification, pageable);
    }
}
