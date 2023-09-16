package com.example.consumer.model.request;

public class ConsumerUpdateDto {

    String name;

    public ConsumerUpdateDto(String name){
        this.name = name;
    }

    public ConsumerUpdateDto(){}

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
