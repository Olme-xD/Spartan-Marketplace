package com.example.SpartanMarketplace.review;

import com.example.SpartanMarketplace.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    private final UserService userService;

    /**
     * Endpoint to create a new review
     * POST /api/reviews
     */
    @PostMapping
    public ResponseEntity<Review> createReview(@Valid @RequestBody Review review) {
        return ResponseEntity.ok(reviewService.createReview(review));
    }

    /**
     * Endpoint for provider to respond to a review
     * PUT /api/reviews/{id}/respond
     */
    @PutMapping("/{id}/respond")
    public ResponseEntity<Review> respondToReview(@PathVariable Long id, @RequestBody Map<String, String> response) {
        return ResponseEntity.ok(reviewService.respondToReview(id, response.get("sellerText")));
    }

    /**
     * Endpoint to update a review
     * PUT /api/reviews/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @Valid @RequestBody Review reviewDetails) {
        return ResponseEntity.ok(reviewService.updateReview(id, reviewDetails));
    }

    /**
     * Endpoint to delete a review
     * DELETE /api/reviews/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Endpoint to get average rating for a provider's profile
     * GET /api/reviews/provider/{providerId}/rating
     */
    @GetMapping("/provider/{providerId}/rating")
    public ResponseEntity<Double> getProviderRating(@PathVariable Long providerId) {
        return ResponseEntity.ok(reviewService.getAverageProviderRating(userService.getUserById(providerId)));
    }
}
