/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mystore.order.dto;

import java.math.BigDecimal;
import java.util.UUID;

/**
 *
 * @author lucas
 */
public record OrderDTO(UUID id, BigDecimal amount) {

}
