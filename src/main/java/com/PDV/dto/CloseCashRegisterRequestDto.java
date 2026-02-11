package com.PDV.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CloseCashRegisterRequestDto(
        @NotNull
        @DecimalMin(value = "0.00")
        BigDecimal finalAmount
) {}
