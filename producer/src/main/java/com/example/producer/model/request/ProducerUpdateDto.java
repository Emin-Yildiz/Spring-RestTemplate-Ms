package com.example.producer.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class ProducerUpdateDto {

    private String address;
    @Size(max = 10, min = 10, message = "Telefon numarasının başında '0' olmamalı ve 10 haneli bir telefon numarası girilmesi gerekmektedir.")
    private int phone;
    @Email
    private String mail;

    public ProducerUpdateDto(String address, int phone, String mail) {
        this.address = address;
        this.phone = phone;
        this.mail = mail;
    }

    public ProducerUpdateDto(){}

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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
