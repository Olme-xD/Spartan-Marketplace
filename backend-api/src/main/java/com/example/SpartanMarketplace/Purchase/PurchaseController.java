package com.example.SpartanMarketplace.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    public static class PurchaseRequest {
        public Long customerId;
        public Long listingId;
    }

    @PostMapping
    public Purchase createPurchase(@RequestBody PurchaseRequest request) {
        return purchaseService.createPurchase(request.customerId, request.listingId);
    }
}
