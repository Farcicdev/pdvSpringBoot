package com.PDV.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CashRegisterResponseDto(
        Long id,
        String status,
        LocalDateTime openedAt,
        LocalDateTime closedAt,
        BigDecimal initialAmount,
        BigDecimal finalAmount
) {}
