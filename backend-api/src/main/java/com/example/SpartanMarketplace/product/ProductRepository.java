package com.example.SpartanMarketplace.product;

import com.example.SpartanMarketplace.user.User;
import com.example.SpartanMarketplace.listing.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByUser(User user);
    List<Product> findByListing(Listing listing);
    List<Product> findByListingAndIsActive(Listing listing, boolean isActive);
    List<Product> findByIsActive(boolean isActive);
    
    @Query(value = "select * from products p where p.title like %?1%", nativeQuery = true)
    List<Product> searchByTitle(String query);
}
