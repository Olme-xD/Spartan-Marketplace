package com.example.SpartanMarketplace.review;

import com.example.SpartanMarketplace.user.User;
import com.example.SpartanMarketplace.product.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"reviews", "products", "listings"})
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnoreProperties("reviews")
    private Product product;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer rating;

    @Column(columnDefinition = "TEXT")
    private String buyerText;

    @Column(columnDefinition = "TEXT")
    private String sellerText;

    @Column(nullable = false)
    private LocalDateTime dateCreated = LocalDateTime.now();
    
}
