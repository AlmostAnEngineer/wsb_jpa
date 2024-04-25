package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.Specialization;
import com.mysql.cj.xdevapi.AddResult;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "doctor_to_address")
public class DoctorToAdress {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @ManyToOne
    @JoinColumn(name = "doctor_id")
    DoctorEntity doctor;

    @ManyToOne
    @JoinColumn(name = "address_id")
    AddressEntity address;

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }
}