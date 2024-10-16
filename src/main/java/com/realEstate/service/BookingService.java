package com.realEstate.service;

import com.realEstate.entity.Booking;
import com.realEstate.entity.Property;
import com.realEstate.entity.Agent;
import com.realEstate.entity.Client;
import com.realEstate.repository.BookingRepository;
import com.realEstate.repository.PropertyRepository;
import com.realEstate.repository.AgentRepository;
import com.realEstate.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final PropertyRepository propertyRepository;
    private final AgentRepository agentRepository; // Use AgentRepository
    private final ClientRepository clientRepository; // Use ClientRepository

    public BookingService(BookingRepository bookingRepository, PropertyRepository propertyRepository, AgentRepository agentRepository, ClientRepository clientRepository) {
        this.bookingRepository = bookingRepository;
        this.propertyRepository = propertyRepository;
        this.agentRepository = agentRepository;
        this.clientRepository = clientRepository;
    }

    public Booking scheduleViewing(Long propertyId, Long agentId, Long clientId, LocalDateTime viewingTime) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found"));
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Booking booking = new Booking();
        booking.setProperty(property);
        booking.setAgent(agent); // Use Agent instead of User
        booking.setClient(client); // Use Client instead of User
        booking.setViewingTime(viewingTime);
        booking.setStatus("confirmed");

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public List<Booking> getBookingsForAgent(Long agentId) {
        return bookingRepository.findByAgentId(agentId);
    }

    public List<Booking> getBookingsForClient(Long clientId) {
        return bookingRepository.findByClientId(clientId);
    }
}
