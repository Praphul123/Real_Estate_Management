package com.realEstate.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
    public class Agent {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String email;
        private String phoneNumber;

        @OneToMany(mappedBy = "agent")
        private List<Booking> bookings;

        // Constructors, Getters, and Setters
        public Agent() {}

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public List<Booking> getBookings() {
            return bookings;
        }

        public void setBookings(List<Booking> bookings) {
            this.bookings = bookings;
        }
    }


