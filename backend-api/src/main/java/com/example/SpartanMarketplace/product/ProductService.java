package com.example.SpartanMarketplace.product;

import com.example.SpartanMarketplace.user.User;
import com.example.SpartanMarketplace.listing.Listing;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    /**
     * Create a new product
     * Use Case 2.2.1.3: Create and Manage Listings
     */
    public Product createProduct(Product product, MultipartFile imageFile) throws IOException {
        if (imageFile == null || imageFile.isEmpty()) {
            throw new IllegalArgumentException("Image is required for new listings.");
        }

        String base64Image = Base64.getEncoder().encodeToString(imageFile.getBytes());
        String dataUrl = "data:" + imageFile.getContentType() + ";base64," + base64Image;
        product.setImageURLString(dataUrl);

        return productRepository.save(product);
    }

    /**
     * Update product details
     * Use Case 2.2.1.3: Create and Manage Listings
     */
    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        product.setTitle(productDetails.getTitle());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setActive(productDetails.isActive());
        if (productDetails.getImageURLString() != null && !productDetails.getImageURLString().isEmpty()) {
            product.setImageURLString(productDetails.getImageURLString());
        }

        return productRepository.save(product);
    }

    /**
     * Delete a product
     * Use Case 2.2.1.3: Create and Manage Listings
     */
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException("Product not found");
        }
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    public List<Product> getProductsByUser(User user) {
        return productRepository.findByUser(user);
    }

    public List<Product> getProductsByListing(Listing listing) {
        return productRepository.findByListing(listing);
    }

    /**
     * Get all active products for browsing
     * Use Case 2.2.2.2: Browse and Search Listings
     */
    public List<Product> getActiveProducts() {
        return productRepository.findByIsActive(true);
    }

    /**
     * Search products by title
     * Use Case 2.2.2.2: Browse and Search Listings
     */
    public List<Product> searchProducts(String query) {
        return productRepository.searchByTitle(query);
    }
}
