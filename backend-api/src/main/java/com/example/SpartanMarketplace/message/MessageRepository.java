package com.example.SpartanMarketplace.message;

import com.example.SpartanMarketplace.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByProduct(Product product);
    List<Message> findByBuyerId(Long buyerId);
    List<Message> findBySellerId(Long sellerId);
    List<Message> findByBuyerIdOrSellerId(Long buyerId, Long sellerId);
    
}
