package com.microservicos.hrworker.domain.service;

import com.microservicos.hrworker.domain.entity.Worker;
import com.microservicos.hrworker.domain.repository.WorkerRepository;
import com.microservicos.hrworker.dto.WorkerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<WorkerDTO> findAll (){
        return  workerRepository.findAll()
                        .stream()
                        .map(worker -> modelMapper.map(worker, WorkerDTO.class))
                        .collect(Collectors.toList());
    }

    public WorkerDTO findById (Long id){
        Optional<Worker> optionalWorker = workerRepository.findById(id);

        if(optionalWorker.isPresent())
            return modelMapper.map(optionalWorker.get(),WorkerDTO.class);

        throw new RuntimeException("Id: "+ id + " não encontrado");
    }
}
