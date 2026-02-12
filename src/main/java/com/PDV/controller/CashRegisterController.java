package com.PDV.controller;

import com.PDV.dto.CashRegisterResponseDto;
import com.PDV.dto.OpenCashRegisterRequestDto;
import com.PDV.service.CashRegisterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cash-register")
@RequiredArgsConstructor
public class CashRegisterController {

    private final CashRegisterService serviceCashRegister;

    @PostMapping("open")
    public CashRegisterResponseDto open (@RequestBody @Valid OpenCashRegisterRequestDto requestDto){
        return serviceCashRegister.open(requestDto);
    }

}
