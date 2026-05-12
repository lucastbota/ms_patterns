/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mystore.shipment.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 *
 * @author lucas
 */
@Component
public class OrderCreatedListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderCreatedListener.class);

    @KafkaListener(
            topics = "OrderCreated",
            groupId = "order-consumer-group"
    )
    public void onMessage(String payload, Acknowledgment ack) {

        try {
            System.out.println("Evento recebido: " + payload);

            // processa evento
            ack.acknowledge();

        } catch (Exception ex) {
            LOGGER.error("erro...", ex);
        }
    }

}
