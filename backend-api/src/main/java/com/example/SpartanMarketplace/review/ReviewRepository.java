package com.example.SpartanMarketplace.review;

import com.example.SpartanMarketplace.user.User;
import com.example.SpartanMarketplace.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByProduct(Product product);
    List<Review> findByUser(User user);
    List<Review> findByProductUser(User provider);
    
}
