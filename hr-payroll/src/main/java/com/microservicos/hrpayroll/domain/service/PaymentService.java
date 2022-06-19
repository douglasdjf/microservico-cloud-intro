package com.microservicos.hrpayroll.domain.service;

import com.microservicos.hrpayroll.domain.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(String nome, Double dailyInCome, int days){
        return new Payment(nome, dailyInCome,days);
    }
}
