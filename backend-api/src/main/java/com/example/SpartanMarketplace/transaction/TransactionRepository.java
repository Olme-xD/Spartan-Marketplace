package com.example.SpartanMarketplace.transaction;

import com.example.SpartanMarketplace.user.User;
import com.example.SpartanMarketplace.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUser(User user);
    List<Transaction> findByProduct(Product product);
    List<Transaction> findByProductUser(User provider);
}
