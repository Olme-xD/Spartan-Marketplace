package com.example.SpartanMarketplace.review;

import com.example.SpartanMarketplace.user.User;
import com.example.SpartanMarketplace.product.Product;
import com.example.SpartanMarketplace.product.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    /**
     * Create a new review
     * Use Case 2.2.2.5: Review Provider
     */
    public Review createReview(Review review) {
        // Validate rating
    if (review.getRating() == null || review.getRating() < 1 || review.getRating() > 5) {
        throw new IllegalArgumentException("Rating must be between 1 and 5");
    }

    // Validate product exists and fetch full entity
    if (review.getProduct() == null || review.getProduct().getId() == null) {
        throw new IllegalArgumentException("Product ID is required for review");
    }

    Product product = productRepository.findById(review.getProduct().getId())
            .orElseThrow(() -> new EntityNotFoundException("Product not found"));

    // Set the full product entity
    review.setProduct(product);

    // review.setUser(product.getUser());
    
    if (review.getUser() == null || review.getUser().getId() == null) {
        throw new IllegalArgumentException("User ID is required for review");
    }

    return reviewRepository.save(review);
    }

    /**
     * Provider responds to a review
     * Use Case 2.2.1.4: Respond to Reviews
     */
    public Review respondToReview(Long id, String sellerText) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Review not found"));

        review.setSellerText(sellerText);
        return reviewRepository.save(review);
    }

    /**
     * Update a review
     * Use Case 2.2.2.5: Review Provider (edit)
     */
    public Review updateReview(Long id, Review reviewDetails) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Review not found"));

        review.setRating(reviewDetails.getRating());
        review.setBuyerText(reviewDetails.getBuyerText());

        return reviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new EntityNotFoundException("Review not found");
        }
        reviewRepository.deleteById(id);
    }

    public List<Review> getReviewsByProduct(Product product) {
        return reviewRepository.findByProduct(product);
    }

    public List<Review> getReviewsByUser(User user) {
        return reviewRepository.findByUser(user);
    }

    /**
     * Get all reviews for a provider's products
     * Use Case 2.2.1.4: View and respond to reviews
     */
    public List<Review> getReviewsForProvider(User provider) {
        return reviewRepository.findByProductUser(provider);
    }

    /**
     * Calculate average rating for a provider's profile
     * Use Case: Rate Profiles
     * This calculates the average rating across all reviews on all products by this
     * provider
     */
    public double getAverageProviderRating(User provider) {
        List<Review> reviews = reviewRepository.findByProductUser(provider);
        return reviews.stream()
                .mapToInt(Review::getRating)
                .average()
                .orElse(0.0);
    }
}