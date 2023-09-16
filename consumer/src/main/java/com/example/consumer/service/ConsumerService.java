package com.example.consumer.service;

import com.example.consumer.domain.Consumer;
import com.example.consumer.model.request.ConsumerCreateDto;
import com.example.consumer.model.request.ConsumerGetDto;
import com.example.consumer.model.request.ConsumerUpdateDto;

import java.util.List;
import java.util.UUID;

public interface ConsumerService {

    public List<Consumer> getAllConsumer();
    public List<ConsumerGetDto> getAllConsumerDto();
    public ConsumerGetDto getConsumerById(UUID id);
    public ConsumerGetDto addConsumer(ConsumerCreateDto consumer);
    public ConsumerGetDto updateConsumerById(ConsumerUpdateDto consumerIpdateDto, UUID id);
    public String deleteConsumerById(UUID id);
}
