package com.microservicos.hrpayroll.client;

import com.microservicos.hrpayroll.client.dto.WorkerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "${hr-worker.name}",
             path = "/workers")
public interface WorkerClient {

    @GetMapping(value = "/{id}")
    public ResponseEntity<WorkerDTO> findById(@PathVariable("id") Long id);
}
