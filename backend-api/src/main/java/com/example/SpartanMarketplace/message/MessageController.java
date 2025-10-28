package com.example.SpartanMarketplace.message;

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
