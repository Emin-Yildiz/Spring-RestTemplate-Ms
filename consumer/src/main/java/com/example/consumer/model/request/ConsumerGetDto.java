package com.example.consumer.model.request;

import com.example.consumer.domain.Producer;

public class ConsumerGetDto {

    private String name;
    private Producer producer;

    public ConsumerGetDto(String name, Producer producer) {
        this.name = name;
        this.producer = producer;
    }

    public ConsumerGetDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
