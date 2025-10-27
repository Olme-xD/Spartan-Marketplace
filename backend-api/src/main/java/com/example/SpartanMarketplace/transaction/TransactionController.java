package com.example.SpartanMarketplace.transaction;

import com.example.SpartanMarketplace.user.UserService;
// import com.example.SpartanMarketplace.product.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    private final UserService userService;
    // private final ProductService productService;

    /**
     * Endpoint to create a new transaction (purchase)
     * POST /api/transactions
     */
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionService.createTransaction(transaction));
    }

    /**
     * Endpoint to get transaction by ID
     * GET /api/transactions/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

    /**
     * Endpoint to get all transactions for a user (purchase history)
     * GET /api/transactions/user/{userId}
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Transaction>> getUserTransactions(@PathVariable Long userId) {
        return ResponseEntity.ok(transactionService.getTransactionsByUser(userService.getUserById(userId)));
    }

    /**
     * Endpoint to get all transactions for a provider's products (sales history)
     * GET /api/transactions/provider/{providerId}
     */
    @GetMapping("/provider/{providerId}")
    public ResponseEntity<List<Transaction>> getProviderTransactions(@PathVariable Long providerId) {
        return ResponseEntity.ok(transactionService.getTransactionsForProvider(userService.getUserById(providerId)));
    }

    /**
     * Endpoint to delete a transaction
     * DELETE /api/transactions/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
