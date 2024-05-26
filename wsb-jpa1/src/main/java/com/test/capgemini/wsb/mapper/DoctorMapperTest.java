package com.test.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.mapper.DoctorMapper;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.enums.Specialization;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = DoctorMapperTest.class)
public class DoctorMapperTest {

    @Test
    public void doctorToTO()
    {
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(1L);
        doctorEntity.setId(1L);
        doctorEntity.setFirstName("John");
        doctorEntity.setLastName("Doe");
        doctorEntity.setTelephoneNumber("123456789");
        doctorEntity.setEmail("john.doe@example.com");
        doctorEntity.setDoctorNumber("D123");
        doctorEntity.setSpecialization(Specialization.CARDIOLOGIST);

        DoctorTO doctorTO = DoctorMapper.maptToTO(doctorEntity);
        assertEquals(1L, doctorTO.getId());
        assertEquals("John", doctorTO.getFirstName());
        assertEquals("Doe", doctorTO.getLastName());
        assertEquals("123456789", doctorTO.getTelephoneNumber());
        assertEquals("D123", doctorTO.getDoctorNumber());
        assertEquals(Specialization.CARDIOLOGIST, doctorTO.getSpecialization());
    }

    @Test
    public void TOtoDoctor()
    {
        DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(1L);
        doctorTO.setFirstName("John");
        doctorTO.setLastName("Doe");
        doctorTO.setTelephoneNumber("123456789");
        doctorTO.setDoctorNumber("D123");
        doctorTO.setEmail("d@d.example.com");
        doctorTO.setSpecialization(Specialization.CARDIOLOGIST);
        assertEquals(1L, doctorTO.getId());
        assertEquals("John", doctorTO.getFirstName());
        assertEquals("Doe", doctorTO.getLastName());
        assertEquals("123456789", doctorTO.getTelephoneNumber());
        assertEquals("D123", doctorTO.getDoctorNumber());
        assertEquals(Specialization.CARDIOLOGIST, doctorTO.getSpecialization());
    }
}
