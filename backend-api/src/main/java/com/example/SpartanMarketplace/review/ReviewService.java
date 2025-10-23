package com.example.SpartanMarketplace.review;

import com.example.SpartanMarketplace.user.User;
import com.example.SpartanMarketplace.product.Product;
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

    /**
     * Create a new review
     * Use Case 2.2.2.5: Review Provider
     */
    public Review createReview(Review review) {
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
     * Calculate average rating for a product
     */
    public double getAverageRating(Product product) {
        List<Review> reviews = reviewRepository.findByProduct(product);
        return reviews.stream()
            .mapToInt(Review::getRating)
            .average()
            .orElse(0.0);
    }
}
