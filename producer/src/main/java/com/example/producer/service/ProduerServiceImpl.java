package com.example.producer.service;

import com.example.producer.domain.Producer;
import com.example.producer.model.request.ProducerCreateDto;
import com.example.producer.model.request.ProducerUpdateDto;
import com.example.producer.model.response.ProducerGetResponse;
import com.example.producer.repository.ProducerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProduerServiceImpl implements ProducerService {

    private final ProducerRepository producerRepository;
    private final ObjectMapper objectMapper;

    public ProduerServiceImpl(ProducerRepository producerRepository, ObjectMapper objectMapper) {
        this.producerRepository = producerRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public ProducerGetResponse createProducer(ProducerCreateDto producerCreateDto) {
        Producer producer = objectMapper.convertValue(producerCreateDto,Producer.class);
        producerRepository.save(producer);
        return objectMapper.convertValue(producer,ProducerGetResponse.class);
    }

    @Override
    public ProducerUpdateDto updateProducer(ProducerUpdateDto producer, UUID id) {
        Optional<Producer> foundProducer = producerRepository.findById(id);
        if (foundProducer.isPresent()){
            return objectMapper.convertValue(foundProducer.get(), ProducerUpdateDto.class);
        }else{
            return null;
        }
    }

    @Override
    public List<Producer> getAllProducerNotDto() {
        return producerRepository.findAll();
    }

    @Override
    public Producer getProducerByIdNotDto(UUID id) {
        Optional<Producer> foundProducer = producerRepository.findById(id);
        return foundProducer.orElse(null);
    }

    @Override
    public List<ProducerGetResponse> getAllProducer() {
        List<ProducerGetResponse> getResponseList = new ArrayList<>();
        producerRepository.findAll().forEach(
                producer -> getResponseList.add(objectMapper.convertValue(producer,ProducerGetResponse.class))
        );
        return getResponseList;
    }

    @Override
    public ProducerGetResponse getProducerById(UUID id) {
        Optional<Producer> foundProducer = producerRepository.findById(id);
        return foundProducer.map(producer -> objectMapper.convertValue(producer, ProducerGetResponse.class)).orElse(null);
    }

    @Override
    public String deleteProducerById(UUID id) {
        Optional<Producer> foundProducer = producerRepository.findById(id);
        if (foundProducer.isPresent()){
            producerRepository.deleteById(foundProducer.get().getId());
            return "Producer deleted ID: " + id;
        }else{
            return "Producer is not find ID: " + id;
        }
    }
}
