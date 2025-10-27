package com.example.SpartanMarketplace.Purchase;
import com.example.SpartanMarketplace.Customer.Customer;
import com.example.SpartanMarketplace.Customer.CustomerRepository;
import com.example.SpartanMarketplace.Listing.Listing;
import com.example.SpartanMarketplace.Listing.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ListingRepository listingRepository;

    public Purchase createPurchase(Long customerId, Long listingId) {
        // Find the customer and listing from the database
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));

        Listing listing = listingRepository.findById(listingId)
                .orElseThrow(() -> new RuntimeException("Listing not found with id: " + listingId));

        // Create a new purchase and link it
        Purchase purchase = new Purchase();
        purchase.setCustomer(customer);
        purchase.setListing(listing);

        return purchaseRepository.save(purchase);
    }
}