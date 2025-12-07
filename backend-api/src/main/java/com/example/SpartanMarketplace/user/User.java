package com.example.SpartanMarketplace.user;

import com.example.SpartanMarketplace.listing.Listing;
import com.example.SpartanMarketplace.product.Product;
import com.example.SpartanMarketplace.review.Review;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String username;

    @Email
    @NotBlank
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @Lob
    @Column(name = "profile_picture_url", length = 10000000)
    private String profilePictureUrl;

    @Column(nullable = false)
    private LocalDateTime dateCreated = LocalDateTime.now();

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Listing> listings = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Product> products = new ArrayList<>();
    
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Review> reviews = new ArrayList<>();

    public User(Long id) {
        this.id = id;
    }
}
