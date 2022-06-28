package com.microservicos.hrworker.resource;

import com.microservicos.hrworker.domain.service.WorkerService;
import com.microservicos.hrworker.dto.WorkerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@Slf4j
@RestController
@RequestMapping("/workers")
public class WorkerResource {

  /**
   *
   * @Value("${test.config}")
    private String testConfig;*/

    @Autowired
    private Environment env;

    @Autowired
    private WorkerService workerService;

  /*  @GetMapping("/configs")
    public ResponseEntity<Void> getConfigs(){
        log.info("CONFIG= : " + testConfig);
        return ResponseEntity.noContent().build();
    }*/

    @GetMapping
    public ResponseEntity<List<WorkerDTO>> findAll(){
        return ResponseEntity.ok(workerService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<WorkerDTO> findById(@PathVariable("id") Long id){
        log.info("PORTA: " + env.getProperty("local.server.port"));
        return ResponseEntity.ok(workerService.findById(id));
    }
}
