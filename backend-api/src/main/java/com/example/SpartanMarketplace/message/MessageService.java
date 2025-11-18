package com.example.SpartanMarketplace.message;

import com.example.SpartanMarketplace.product.Product;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MessageService {
    private final MessageRepository messageRepository;

    /**
     * Send a message
     * Use Case 2.2.2.4: Contact Provider
     */
    public Message sendMessage(Message message) {
        return messageRepository.save(message);
    }

    /**
     * Get conversation for a specific product
     * Use Case 2.2.2.4: View conversation
     */
    public List<Message> getMessagesByProduct(Product product) {
        return messageRepository.findByProduct(product);
    }

    /**
     * Get all messages for a buyer
     */
    public List<Message> getMessagesByBuyerId(Long buyerId) {
        return messageRepository.findByBuyerId(buyerId);
    }

    /**
     * Get all messages for a seller
     */
    public List<Message> getMessagesBySellerId(Long sellerId) {
        return messageRepository.findBySellerId(sellerId);
    }

    /**
     * Get all messages for a user (as buyer or seller)
     */
    public List<Message> getMessagesForUser(Long userId) {
        return messageRepository.findByBuyerIdOrSellerId(userId, userId);
    }

    public Message getMessageById(Long id) {
        return messageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Message not found"));
    }

    public void deleteMessage(Long id) {
        if (!messageRepository.existsById(id)) {
            throw new EntityNotFoundException("Message not found");
        }
        messageRepository.deleteById(id);
    }

    public Message updateMessage(Long chatId, Message messageDetails) {
        Message message = messageRepository.findById(chatId)
                .orElseThrow(() -> new EntityNotFoundException("Message not found"));

        if (messageDetails.getBuyerText() != null && !messageDetails.getBuyerText().isEmpty()) {
            message.setBuyerText(messageDetails.getBuyerText());
        }
        if (messageDetails.getSellerText() != null && !messageDetails.getSellerText().isEmpty()) {
            message.setSellerText(messageDetails.getSellerText());
        }

        return messageRepository.save(message);
    }
}