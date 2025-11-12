package com.example.SpartanMarketplace.listing;

import com.example.SpartanMarketplace.user.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ListingService {
    private final ListingRepository listingRepository;

    /**
     * Create a new listing
     * Use Case 2.2.1.3: Create and Manage Listings
     */
    public Listing createListing(Listing listing) {
        return listingRepository.save(listing);
    }

    /**
     * Update listing details
     * Use Case 2.2.1.3: Create and Manage Listings
     */
    public Listing updateListing(Long id, Listing listingDetails) {
        Listing listing = listingRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Listing not found"));

        listing.setCategory(listingDetails.getCategory());
        listing.setActive(listingDetails.isActive());

        return listingRepository.save(listing);
    }

    /**
     * Delete a listing
     * Use Case 2.2.1.3: Create and Manage Listings
     */
    public void deleteListing(Long id) {
        if (!listingRepository.existsById(id)) {
            throw new EntityNotFoundException("Listing not found");
        }
        listingRepository.deleteById(id);
    }

    public Listing getListingById(Long id) {
        return listingRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Listing not found"));
    }

    public List<Listing> getListingsByUser(User user) {
        return listingRepository.findByUser(user);
    }

    /**
     * Get active listings for a specific provider
     * Use Case 2.2.1.3: View Statistics
     */
    public List<Listing> getActiveListingsByUser(User user) {
        return listingRepository.findByUserAndIsActive(user, true);
    }

    /**
     * Get all active listings (for browsing)
     * Use Case 2.2.2.2: Browse and Search Listings
     */
    public List<Listing> getAllActiveListings() {
        return listingRepository.findByIsActive(true);
    }

    public List<Listing> getListingsByCategory(String category) {
        return listingRepository.findByCategoryAndIsActive(category, true);
    }
}
