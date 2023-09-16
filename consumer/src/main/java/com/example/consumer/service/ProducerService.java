package com.example.consumer.service;

import com.example.consumer.domain.Producer;

import java.util.List;
import java.util.UUID;

public interface ProducerService {

    public List<Producer> getAllProducerNotDto();
    public Producer getProducerById(UUID id);
}
