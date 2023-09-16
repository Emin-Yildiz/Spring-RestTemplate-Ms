package com.example.consumer.service;

import com.example.consumer.domain.Producer;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class ProducerServiceImpl implements ProducerService{
    private final RestTemplate restTemplate;

    private final String URL = "http://localhost:8080/producer";

    public ProducerServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Producer> getAllProducerNotDto() {
        ResponseEntity<List<Producer>> response = restTemplate.exchange(URL, HttpMethod.GET,null,new ParameterizedTypeReference<List<Producer>>() {});
        return response.getBody();
    }

    @Override
    public Producer getProducerById(UUID id){
        return restTemplate.getForObject(URL + "/" + id, Producer.class);
    }
}
