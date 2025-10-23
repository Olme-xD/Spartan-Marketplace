package com.example.SpartanMarketplace.transaction;

import com.example.SpartanMarketplace.user.User;
import com.example.SpartanMarketplace.product.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"transactions", "products", "listings"})
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnoreProperties("transactions")
    private Product product;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime transactionDate = LocalDateTime.now();
    
}
