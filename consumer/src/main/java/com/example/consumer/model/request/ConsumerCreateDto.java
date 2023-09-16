package com.example.consumer.model.request;

import java.util.UUID;

public class ConsumerCreateDto {

    private String name;
    private UUID producerId;

    public ConsumerCreateDto(String name, UUID producerId) {
        this.name = name;
        this.producerId = producerId;
    }

    public ConsumerCreateDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getProducerId() {
        return producerId;
    }

    public void setProducerId(UUID id) {
        this.producerId = id;
    }
}
