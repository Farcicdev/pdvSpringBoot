package com.PDV.service;

import com.PDV.dto.CashRegisterResponseDto;
import com.PDV.dto.OpenCashRegisterRequestDto;
import com.PDV.model.CashRegister;
import com.PDV.repository.CashRegisterRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CashRegisterService {

    private static final String STATUS_OPEN = "OPEN";

    private static final String STATUS_CLOSED = "CLOSED";

    private CashRegisterRepository repository;

    @Transactional
    public CashRegisterResponseDto open(OpenCashRegisterRequestDto requestDto) {

//        nao pode abrir se ja existe um caixa aberto
        repository.findFirstByStatus(STATUS_OPEN)
                .ifPresent(cr -> {
                    throw new IllegalStateException("ja existe um caixa aberto");
                });
//        valor inicial
        BigDecimal initialAmount = requestDto.initialAmount();
        if (initialAmount == null) initialAmount = BigDecimal.ZERO;
        if (initialAmount.signum() < 0) {
            throw new IllegalArgumentException("valor nao pode ser negativo");
        }

//        cria o caixa
        CashRegister cashRegister = new CashRegister();
        cashRegister.setStatus(STATUS_OPEN);
        cashRegister.setOpenedAt(LocalDateTime.now());
        cashRegister.setClosedAt(null);
        cashRegister.setFinalAmount(null);

//        salva
        CashRegister saved = repository.save(cashRegister);

//        retornar DTO
        return new CashRegisterResponseDto(
                saved.getId(),
                saved.getStatus(),
                saved.getOpenedAt(),
                saved.getClosedAt(),
                saved.getInitialAmount(),
                saved.getFinalAmount()
        );
    }

}
