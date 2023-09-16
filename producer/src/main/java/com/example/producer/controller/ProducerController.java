package com.example.producer.controller;

import com.example.producer.domain.Producer;
import com.example.producer.model.request.ProducerCreateDto;
import com.example.producer.model.request.ProducerUpdateDto;
import com.example.producer.model.response.ProducerGetResponse;
import com.example.producer.service.ProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping
    public ResponseEntity<ProducerGetResponse> createProduer(@RequestBody ProducerCreateDto producerCreateDto){
        return new ResponseEntity<>(producerService.createProducer(producerCreateDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Producer>> getAllProducerNotDto(){
        return new ResponseEntity<>(producerService.getAllProducerNotDto(), HttpStatus.FOUND);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<ProducerGetResponse>> getAllProducerWithDto(){
        return new ResponseEntity<>(producerService.getAllProducer(), HttpStatus.FOUND);
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<ProducerGetResponse> getProducerById(@PathVariable UUID id){
        return new ResponseEntity<>(producerService.getProducerById(id),HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producer> getProducerByIdNotDto(@PathVariable UUID id){
        return new ResponseEntity<>(producerService.getProducerByIdNotDto(id),HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProducerUpdateDto> producerUpdateById(@RequestBody ProducerUpdateDto updateDto, @PathVariable UUID id){
        return new ResponseEntity<>(producerService.updateProducer(updateDto, id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProducerById(@PathVariable UUID id){
        return new ResponseEntity<>(producerService.deleteProducerById(id),HttpStatus.OK);
    }
}
