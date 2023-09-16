package com.example.consumer.controller;

import com.example.consumer.domain.Consumer;
import com.example.consumer.model.request.ConsumerCreateDto;
import com.example.consumer.model.request.ConsumerGetDto;
import com.example.consumer.model.request.ConsumerUpdateDto;
import com.example.consumer.service.ConsumerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    private final ConsumerService consumerService;

    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @PostMapping
    public ResponseEntity<ConsumerGetDto> addConsumer(@RequestBody ConsumerCreateDto consumer){
        return new ResponseEntity<>(consumerService.addConsumer(consumer), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Consumer>> getAllConsumer(){
        return new ResponseEntity<>(consumerService.getAllConsumer(),HttpStatus.FOUND);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<ConsumerGetDto>> getAllConsumerDto(){
        return new ResponseEntity<>(consumerService.getAllConsumerDto(),HttpStatus.FOUND);
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<ConsumerGetDto> getConsumerFtoById(@PathVariable UUID id){
        return new ResponseEntity<>(consumerService.getConsumerById(id),HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsumerGetDto> updateConsumerById(@RequestBody ConsumerUpdateDto updateDto, @PathVariable UUID id){
        return new ResponseEntity<>(consumerService.updateConsumerById(updateDto,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteConsumerById(@PathVariable UUID id){
        return new ResponseEntity<>(consumerService.deleteConsumerById(id),HttpStatus.OK);
    }

}

