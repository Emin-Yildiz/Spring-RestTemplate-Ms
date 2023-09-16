package com.example.producer.service;

import com.example.producer.domain.Producer;
import com.example.producer.model.request.ProducerCreateDto;
import com.example.producer.model.request.ProducerUpdateDto;
import com.example.producer.model.response.ProducerGetResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProducerService {

    public ProducerGetResponse createProducer(ProducerCreateDto producer);
    public ProducerUpdateDto updateProducer(ProducerUpdateDto producer,UUID id);
    public List<Producer> getAllProducerNotDto();
    public Producer getProducerByIdNotDto(UUID id);
    public List<ProducerGetResponse> getAllProducer();
    public ProducerGetResponse getProducerById(UUID id);
    public String deleteProducerById(UUID id);
}
