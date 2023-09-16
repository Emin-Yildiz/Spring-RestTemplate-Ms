package com.example.producer.domain;

import com.example.producer.domain.Audit.DateAudit;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "producer")
public class Producer extends DateAudit {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String name;
    private String address;
    private int phone;
    private String mail;

    public Producer(Date createdDate, Date modifiedDate, UUID id, String name, String address, int phone, String mail) {
        super(createdDate, modifiedDate);
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
    }

    public Producer(UUID id, String name, String address, int phone, String mail){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
    }

    public Producer() {}

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getMail(){
        return mail;
    }

    public void setMail(String mail){
        this.mail = mail;
    }
}
