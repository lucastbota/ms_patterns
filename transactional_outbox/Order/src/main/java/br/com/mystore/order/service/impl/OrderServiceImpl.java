/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mystore.order.service.impl;

import br.com.mystore.order.service.*;
import br.com.mystore.order.entity.Order;
import br.com.mystore.order.entity.OutboxEvent;
import br.com.mystore.order.entity.custom.OrderCreatedEvent;
import br.com.mystore.order.repository.OrderRepository;
import br.com.mystore.order.repository.OutboxRepository;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orders;
    private final OutboxRepository outbox;

    public OrderServiceImpl(
            OrderRepository orders,
            OutboxRepository outbox
    ) {
        this.orders = orders;
        this.outbox = outbox;
    }

    @Transactional
    public Order createOrder(BigDecimal amount) {

        Order order = new Order(UUID.randomUUID(), amount);
        orders.save(order);

        OrderCreatedEvent event
                = new OrderCreatedEvent(order.getId(), amount);

        outbox.save(
                OutboxEvent.create(
                        "Order",
                        order.getId(),
                        event
                )
        );
        return order;
    }
}
