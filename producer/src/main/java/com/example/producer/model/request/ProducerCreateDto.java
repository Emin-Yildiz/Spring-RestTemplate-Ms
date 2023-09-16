package com.example.producer.model.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProducerCreateDto {

    @NotNull
    private String name;
    private String address;
    @Size(min = 10, message = "Telefon numarasının başında '0' olmamalı ve 10 haneli bir telefon numarası girilmesi gerekmektedir.")
    private String phone;
    @Email
    private String mail;

    public ProducerCreateDto(@Nullable String name, String address, String phone, String mail) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
    }

    public ProducerCreateDto(){}

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
