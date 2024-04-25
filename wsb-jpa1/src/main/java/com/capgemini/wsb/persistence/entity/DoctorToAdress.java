package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.Specialization;
import com.mysql.cj.xdevapi.AddResult;

import javax.persistence.*;
import java.util.Collection;

@Entity(name="doctor_to_address")
@Table(name = "doctor_to_address")
public class DoctorToAdress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    DoctorEntity doctor;

    @ManyToOne
    @JoinColumn(name = "address_id")
    AddressEntity address;
}