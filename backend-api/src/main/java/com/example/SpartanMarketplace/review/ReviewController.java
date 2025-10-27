package com.example.SpartanMarketplace.review;

import com.example.SpartanMarketplace.user.UserService;
//import com.example.SpartanMarketplace.product.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    //private final ProductService productService;
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

    // /**
    //  * Endpoint to get all reviews for a product
    //  * GET /api/reviews/product/{productId}
    //  */
    // @GetMapping("/product/{productId}")
    // public ResponseEntity<List<Review>> getProductReviews(@PathVariable Long productId) {
    //     return ResponseEntity.ok(reviewService.getReviewsByProduct(productService.getProductById(productId)));
    // }

    /**
     * Endpoint to get all reviews by a user
     * GET /api/reviews/user/{userId}
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Review>> getUserReviews(@PathVariable Long userId) {
        return ResponseEntity.ok(reviewService.getReviewsByUser(userService.getUserById(userId)));
    }

    // /**
    //  * Endpoint to get all reviews for a provider's products
    //  * GET /api/reviews/provider/{providerId}
    //  */
    // @GetMapping("/provider/{providerId}")
    // public ResponseEntity<List<Review>> getProviderReviews(@PathVariable Long providerId) {
    //     return ResponseEntity.ok(reviewService.getReviewsForProvider(userService.getUserById(providerId)));
    // }

    /**
     * Endpoint to get average rating for a provider's profile
     * GET /api/reviews/provider/{providerId}/rating
     */
    @GetMapping("/provider/{providerId}/rating")
    public ResponseEntity<Double> getProviderRating(@PathVariable Long providerId) {
        return ResponseEntity.ok(reviewService.getAverageProviderRating(userService.getUserById(providerId)));
    }
}
