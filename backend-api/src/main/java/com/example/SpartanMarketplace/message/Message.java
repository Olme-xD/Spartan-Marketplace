package com.example.SpartanMarketplace.message;

import com.example.SpartanMarketplace.product.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnoreProperties("messages")
    private Product product;

    @Column(nullable = false)
    private Long buyerId;

    @Column(nullable = false)
    private Long sellerId;

    @Column(columnDefinition = "TEXT")
    private String buyerText;

    @Column(columnDefinition = "TEXT")
    private String sellerText;

    @Column(nullable = false)
    private LocalDateTime dateCreated = LocalDateTime.now();
    
}
