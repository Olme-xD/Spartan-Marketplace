package com.example.SpartanMarketplace.listing;

import com.example.SpartanMarketplace.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/listings")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ListingController {
    private final ListingService listingService;
    private final UserService userService;

    /**
     * Endpoint to create a new listing
     * POST /api/listings
     */
    @PostMapping
    public ResponseEntity<Listing> createListing(@Valid @RequestBody Listing listing) {
        return ResponseEntity.ok(listingService.createListing(listing));
    }

    /**
     * Endpoint to update a listing
     * PUT /api/listings/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Listing> updateListing(@PathVariable Long id, @Valid @RequestBody Listing listingDetails) {
        return ResponseEntity.ok(listingService.updateListing(id, listingDetails));
    }

    /**
     * Endpoint to delete a listing
     * DELETE /api/listings/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListing(@PathVariable Long id) {
        listingService.deleteListing(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Endpoint to get listing by ID
     * GET /api/listings/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Listing> getListing(@PathVariable Long id) {
        return ResponseEntity.ok(listingService.getListingById(id));
    }

    /**
     * Endpoint to get all listings for a user
     * GET /api/listings/user/{userId}
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Listing>> getUserListings(@PathVariable Long userId) {
        return ResponseEntity.ok(listingService.getListingsByUser(userService.getUserById(userId)));
    }

    /**
     * Endpoint to get all active listings by category
     * GET /api/listings/category/{category}
     */
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Listing>> getListingsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(listingService.getListingsByCategory(category));
    }

    /**
     * Endpoint to get all active listings
     * GET /api/listings/active
     */
    @GetMapping("/active")
    public ResponseEntity<List<Listing>> getAllActiveListings() {
        return ResponseEntity.ok(listingService.getAllActiveListings());
    }
}
