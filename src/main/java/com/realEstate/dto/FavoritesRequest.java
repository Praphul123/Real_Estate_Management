package com.realEstate.dto;


import java.util.List;

public class FavoritesRequest {
    private Long clientId;
    private List<Long> propertyIds;

    public FavoritesRequest(List<Long> propertyIds, Long clientId) {
        this.propertyIds = propertyIds;
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<Long> getPropertyIds() {
        return propertyIds;
    }

    public void setPropertyIds(List<Long> propertyIds) {
        this.propertyIds = propertyIds;
    }

}
