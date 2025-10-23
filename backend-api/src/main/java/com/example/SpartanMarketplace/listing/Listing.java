package com.example.SpartanMarketplace.listing;

import com.example.SpartanMarketplace.user.User;
import com.example.SpartanMarketplace.product.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "listings")
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties("listings")
    private User user;

    @NotBlank
    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private boolean isActive = true;

    @Column(nullable = false)
    private LocalDateTime dateCreated = LocalDateTime.now();

    @OneToMany(mappedBy = "listing", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("listing")
    private List<Product> products = new ArrayList<>();
    
}
