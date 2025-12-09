package com.example.SpartanMarketplace.user;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    /**
     * Create a new user (Sign up)
     * Use Case 2.2.1.1 & 2.2.2.1: Sign up
     */
    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalStateException("Email already registered");
        }
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalStateException("Username already taken");
        }
        return userRepository.save(user);
    }

    /**
     * Checks for user login (Login)
     * Use Case: Login
     * 
     * @return true if valid, false otherwise.
     */
    public boolean validateUser(String email, String password) {
        User user = userRepository.findByEmail(email).orElse(null);

        if (user == null) {
            return false; // User not found
        }
        return user.getPassword().equals(password);
    }

    /**
     * Update user profile
     * Use Case 2.2.1.2: Manage Profile
     */
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setPhoneNumber(userDetails.getPhoneNumber());

        return userRepository.save(user);
    }

    /**
     * Get user by ID
     */
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    /**
     * Get user by Email
     */
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    /**
     * Get all users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Delete a user
     */
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User not found");
        }
        userRepository.deleteById(id);
    }

    /**
     * Upload or Update Profile Image
     */
    public User uploadProfileImage(Long id, MultipartFile file) throws IOException {
        User user = getUserById(id);

        if (file != null && !file.isEmpty()) {
            String base64Image = Base64.getEncoder().encodeToString(file.getBytes());
            String dataUrl = "data:" + file.getContentType() + ";base64," + base64Image;
            user.setProfilePictureUrl(dataUrl);
        }

        return userRepository.save(user);
    }
}
