package com.realEstate.dto;

import java.time.LocalDateTime;

public class BookingRequest {

    private Long propertyId;
    private Long agentId;
    private Long clientId;
    private LocalDateTime viewingTime;

    // Getters and Setters
    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getViewingTime() {
        return viewingTime;
    }

    public void setViewingTime(LocalDateTime viewingTime) {
        this.viewingTime = viewingTime;
    }
}
