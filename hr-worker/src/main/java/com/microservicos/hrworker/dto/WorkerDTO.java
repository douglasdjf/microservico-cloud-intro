package com.microservicos.hrworker.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkerDTO implements Serializable {

    private Long id;
    private String name;
    private Double dailyIncome;
}
