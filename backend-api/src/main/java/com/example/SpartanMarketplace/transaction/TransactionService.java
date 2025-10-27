package com.example.SpartanMarketplace.transaction;

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
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final ProductRepository productRepository;

    /**
     * Create a new transaction (complete purchase)
     * Marks product as sold/inactive
     * Use Case 2.2.2.3: Purchase Item or Service
     */
    public Transaction createTransaction(Transaction transaction) {
        Product product = transaction.getProduct();
        
        // Check if product is still available
        if (!product.isActive()) {
            throw new IllegalStateException("Product is no longer available");
        }
        
        // Save the transaction
        Transaction savedTransaction = transactionRepository.save(transaction);
        
        // Mark product as sold
        product.setActive(false);
        productRepository.save(product);
        
        return savedTransaction;
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Transaction not found"));
    }

    /**
     * Get transaction history for a user
     * Use Case 2.2.2.3: View purchase history
     */
    public List<Transaction> getTransactionsByUser(User user) {
        return transactionRepository.findByUser(user);
    }

    public List<Transaction> getTransactionsByProduct(Product product) {
        return transactionRepository.findByProduct(product);
    }

    /**
     * Get all transactions for a provider's products
     */
    public List<Transaction> getTransactionsForProvider(User provider) {
        return transactionRepository.findByProductUser(provider);
    }

    public void deleteTransaction(Long id) {
        if (!transactionRepository.existsById(id)) {
            throw new EntityNotFoundException("Transaction not found");
        }
        transactionRepository.deleteById(id);
    }
}
