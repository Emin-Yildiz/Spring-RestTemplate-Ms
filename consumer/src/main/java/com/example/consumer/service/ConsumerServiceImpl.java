package com.example.consumer.service;

import com.example.consumer.domain.Consumer;
import com.example.consumer.domain.Producer;
import com.example.consumer.model.request.ConsumerCreateDto;
import com.example.consumer.model.request.ConsumerGetDto;
import com.example.consumer.model.request.ConsumerUpdateDto;
import com.example.consumer.repository.ConsumerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    private final ProducerService producerService;
    private final ConsumerRepository consumerRepository;
    private final ObjectMapper objectMapper;

    public ConsumerServiceImpl(ProducerService producerService, ConsumerRepository consumerRepository, ObjectMapper objectMapper) {
        this.producerService = producerService;
        this.consumerRepository = consumerRepository;
        this.objectMapper = objectMapper;
    }


    @Override
    public List<Consumer> getAllConsumer() {
        return consumerRepository.findAll();
    }

    @Override
    public List<ConsumerGetDto> getAllConsumerDto() {
        List<ConsumerGetDto> list = new ArrayList<>();
        consumerRepository.findAll().forEach(
                consumer -> {
                    ConsumerGetDto getDto = new ConsumerGetDto();
                    getDto.setName(consumer.getName());
                    getDto.setProducer(consumer.getProducerId());
                    list.add(getDto);
                }
        );
        return list;
    }

    @Override
    public ConsumerGetDto getConsumerById(UUID id) {
        ConsumerGetDto getDto = new ConsumerGetDto();
        Optional<Consumer> foundConsumer= consumerRepository.findById(id);
        if(foundConsumer.isPresent()){
            getDto.setProducer(foundConsumer.get().getProducerId());
            getDto.setName(foundConsumer.get().getName());
            return getDto;
        }else {
            return null;
        }
    }

    @Override
    public ConsumerGetDto addConsumer(ConsumerCreateDto consumerDto) {
        Consumer newConsumer = new Consumer();
        ConsumerGetDto getDto = new ConsumerGetDto();
        Optional<Producer> foundProducer = Optional.ofNullable(producerService.getProducerById(consumerDto.getProducerId()));
        if(foundProducer.isPresent()){
            newConsumer.setProducerId(foundProducer.get());
            newConsumer.setName(consumerDto.getName());
            consumerRepository.save(newConsumer);
            getDto.setProducer(newConsumer.getProducerId());
            getDto.setName(newConsumer.getName());
            return getDto;
        }else {
            return null;
        }

    }

    @Override
    public ConsumerGetDto updateConsumerById(ConsumerUpdateDto consumerUpdateDto, UUID id) {
        Optional<Consumer> foundConsumer = consumerRepository.findById(id);
        ConsumerGetDto getDto = new ConsumerGetDto();
        if (foundConsumer.isPresent()){
            Consumer newConsumer = foundConsumer.get();
            newConsumer.setName(consumerUpdateDto.getName());
            consumerRepository.save(newConsumer);
            getDto.setName(newConsumer.getName());
            getDto.setProducer(newConsumer.getProducerId());
            return getDto;
        }else {
            return null;
        }
    }

    @Override
    public String deleteConsumerById(UUID id) {
        Optional<Consumer> foundConsumer = consumerRepository.findById(id);
        if (foundConsumer.isPresent()){
            consumerRepository.delete(foundConsumer.get());
            return "Consumer deleted.. ID: " + id;
        }else {
            return "Consumer not found";
        }
    }
}
