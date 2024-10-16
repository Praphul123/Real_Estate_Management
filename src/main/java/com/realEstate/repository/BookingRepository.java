
package com.realEstate.repository;

import com.realEstate.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByAgentId(Long agentId);
    List<Booking> findByClientId(Long clientId);
}

