package com.example.SpartanMarketplace.message;

import com.example.SpartanMarketplace.product.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;
    private final ProductService productService;

    /**
     * Endpoint to send a message
     * POST /api/messages
     */
    @PostMapping
    public ResponseEntity<Message> sendMessage(@Valid @RequestBody Message message) {
        return ResponseEntity.ok(messageService.sendMessage(message));
    }

    /**
     * Endpoint to get message by ID
     * GET /api/messages/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable Long id) {
        return ResponseEntity.ok(messageService.getMessageById(id));
    }

    /**
     * Endpoint to get all messages for a product
     * GET /api/messages/product/{productId}
     */
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Message>> getProductMessages(@PathVariable Long productId) {
        return ResponseEntity.ok(messageService.getMessagesByProduct(productService.getProductById(productId)));
    }

    /**
     * Endpoint to get all messages for a buyer
     * GET /api/messages/buyer/{buyerId}
     */
    @GetMapping("/buyer/{buyerId}")
    public ResponseEntity<List<Message>> getBuyerMessages(@PathVariable Long buyerId) {
        return ResponseEntity.ok(messageService.getMessagesByBuyerId(buyerId));
    }

    /**
     * Endpoint to get all messages for a seller
     * GET /api/messages/seller/{sellerId}
     */
    @GetMapping("/seller/{sellerId}")
    public ResponseEntity<List<Message>> getSellerMessages(@PathVariable Long sellerId) {
        return ResponseEntity.ok(messageService.getMessagesBySellerId(sellerId));
    }

    /**
     * Endpoint to get all messages for a user (as buyer or seller)
     * GET /api/messages/user/{userId}
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Message>> getUserMessages(@PathVariable Long userId) {
        return ResponseEntity.ok(messageService.getMessagesForUser(userId));
    }

    /**
     * Endpoint to delete a message
     * DELETE /api/messages/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }
}
