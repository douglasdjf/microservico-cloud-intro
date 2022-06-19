package com.microservicos.hrpayroll.resource;

import com.microservicos.hrpayroll.client.WorkerClient;
import com.microservicos.hrpayroll.client.dto.WorkerDTO;
import com.microservicos.hrpayroll.domain.entity.Payment;
import com.microservicos.hrpayroll.domain.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private WorkerClient workerClient;

    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable("workerId") Long workerId, @PathVariable("days") Integer days){
        WorkerDTO workerDTO = workerClient.findById(workerId).getBody();
        return ResponseEntity.ok(paymentService.getPayment(workerDTO.getName(),workerDTO.getDailyIncome(),days));
    }
}
