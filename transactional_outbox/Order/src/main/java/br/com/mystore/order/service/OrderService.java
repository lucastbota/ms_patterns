/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mystore.order.service;

import br.com.mystore.order.entity.Order;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public interface OrderService {

    Order createOrder(BigDecimal amount);
}
