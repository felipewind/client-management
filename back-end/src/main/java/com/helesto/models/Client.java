package com.helesto.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @SequenceGenerator(
            name = "CLIENT_SEQUENCE",
            sequenceName = "CLIENT_ID_SEQUENCE",
            allocationSize = 1,
            initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENT_SEQUENCE")
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME", length = 80)
    private String name;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Column(name = "EMAIL", length = 80)
    private String email;

    @Column(name = "PHONE_NUMBER")
    private long phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
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
