package com.example.SpartanMarketplace.listing;

import com.example.SpartanMarketplace.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {
    List<Listing> findByUser(User user);
    List<Listing> findByUserAndIsActive(User user, boolean isActive);
    List<Listing> findByCategory(String category);
    List<Listing> findByIsActive(boolean isActive);
    List<Listing> findByCategoryAndIsActive(String category, boolean isActive);
    
}
