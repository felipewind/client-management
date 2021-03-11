package com.helesto.dto;

import com.helesto.models.Client;
import com.helesto.utils.DateUtils;

public class ClientDto {

    public ClientDto() {
        
    }

    public ClientDto(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.birthDate = DateUtils.localDateToStringMmDdYyyy(client.getBirthDate());
        this.email = client.getEmail();
        this.phoneNumber = client.getPhoneNumber();
    }    


    private int id;

    private String name;

    private String birthDate;

    private String email;

    private long phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
}
