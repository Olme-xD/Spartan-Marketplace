package com.example.SpartanMarketplace.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;

    /**
     * Endpoint to create a new user (Sign Up)
     * POST /api/users
     */
    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        try {
            User registeredUser = userService.createUser(user);
            return ResponseEntity.ok(registeredUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }

    /**
     * Endpoint to update user profile
     * PUT /api/users/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User userDetails) {
        return ResponseEntity.ok(userService.updateUser(id, userDetails));
    }

    /**
     * Endpoint to get user by ID
     * GET /api/users/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    /*
     * Endpoint to get all users
     * Get /api/users
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     * Endpoint to delete user
     * DELETE /api/users/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Endpoint to check user login
     * POST /api/users/login
     */
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        boolean isValid = userService.validateUser(loginRequest.getEmail(), loginRequest.getPassword());

        if (isValid) {
            // Set user_session cookie
            Cookie cookie = new Cookie("user_session", "active");
            cookie.setPath("/");
            cookie.setMaxAge(7 * 24 * 60 * 60); // 1 week
            cookie.setHttpOnly(false);
            response.addCookie(cookie);

            // Also set user_id cookie
            User user = userService.getUserByEmail(loginRequest.getEmail());
            Cookie idCookie = new Cookie("user_id", String.valueOf(user.getId()));
            idCookie.setPath("/");
            idCookie.setMaxAge(7 * 24 * 60 * 60); // 1 week
            response.addCookie(idCookie);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(401).body("Invalid Credentials");
        }
    }

    /**
     * Endpoint to upload profile image
     * POST /api/users/{id}/image
     */
    @PostMapping(value = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadProfileImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
            return ResponseEntity.ok(userService.uploadProfileImage(id, file));
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error processing image");
        }
    }
}
