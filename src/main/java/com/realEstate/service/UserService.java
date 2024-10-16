package com.realEstate.service;

import com.realEstate.entity.User;
import com.realEstate.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Fetch all users (admin only)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Fetch a specific user by ID
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    // Register a new user
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // Update a user's details
    public Optional<User> updateUser(Long userId, User userDetails) {
        return userRepository.findById(userId).map(user -> {
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            return userRepository.save(user);
        });
    }

    // Delete a user by ID
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    // Assign roles to a user (admin only)
    public Optional<User> assignRoles(Long userId, Set<String> roles) {
        return userRepository.findById(userId).map(user -> {
            user.setRoles(roles);
            return userRepository.save(user);
        });
    }
}
