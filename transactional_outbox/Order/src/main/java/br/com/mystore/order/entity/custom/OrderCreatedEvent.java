/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mystore.order.entity.custom;

import java.math.BigDecimal;
import java.util.UUID;

/**
 *
 * @author lucas
 */
public record OrderCreatedEvent(
        UUID orderId,
        BigDecimal amount
        ) implements DomainEvent {

    @Override
    public String eventType() {
        return "OrderCreated";
    }

    @Override
    public int eventVersion() {
        return 1;
    }
}
