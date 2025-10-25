package com.example.SpartanMarketplace.product;

import com.example.SpartanMarketplace.user.User;
import com.example.SpartanMarketplace.listing.Listing;
//import com.example.SpartanMarketplace.transaction.Transaction;
//import com.example.SpartanMarketplace.review.Review;
//import com.example.SpartanMarketplace.message.Message;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
// import java.util.ArrayList;
// import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "listing_id", nullable = false)
    @JsonIgnoreProperties("products")
    private Listing listing;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties("products")
    private User user;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull
    @Positive
    private BigDecimal price;

    @Column(nullable = false)
    private boolean isActive = true;

    // @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    // @JsonIgnoreProperties("product")
    // private List<Transaction> transactions = new ArrayList<>();

    // @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    // @JsonIgnoreProperties("product")
    // private List<Review> reviews = new ArrayList<>();

    // @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    // @JsonIgnoreProperties("product")
    // private List<Message> messages = new ArrayList<>();

}
