package com.example.consumer.domain;

import com.example.consumer.domain.audit.DateAudit;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "consumer")
public class Consumer extends DateAudit {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private UUID id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    private Producer producer;

    public Consumer(UUID id, String name, Producer producer) {
        this.id = id;
        this.name = name;
        this.producer = producer;
    }

    public Consumer() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Producer getProducerId() {
        return producer;
    }

    public void setProducerId(Producer producer) {
        this.producer = producer;
    }
}
