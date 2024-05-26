package com.test.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = PatientMapperTest.class)
public class PatientMapperTest {
    @Test
    public void entityToTOTest() {
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(1L);
        patientEntity.setFirstName("Grzegorz");
        patientEntity.setLastName("Grzegorz");
        patientEntity.setTelephoneNumber("2130073213");
        patientEntity.setPatientNumber("XYZ111");
        patientEntity.setDateOfBirth(LocalDate.of(2022, 5, 23));
        patientEntity.setEmail("Grzegorz@example.com");
        patientEntity.setPatientHistory("He's a pickle!");

        PatientTO patientTO = PatientMapper.mapToTO(patientEntity);

        assertNotNull(patientTO);
        assertEquals(1L, patientTO.getId());
        assertEquals("Grzegorz", patientTO.getFirstName());
        assertEquals("Grzegorz", patientTO.getLastName());
        assertEquals("2130073213", patientTO.getTelephoneNumber());
        assertEquals("XYZ111", patientTO.getPatientNumber());
        assertEquals("He's a pickle!", patientTO.getPatientHistory());
        assertEquals("Grzegorz@example.com", patientTO.getEmail());
        assertEquals(LocalDate.of(2022, 5, 23), patientTO.getDateOfBirth());
    }

    @Test
    public void TOToEntity()
    {
        PatientTO patientTO = new PatientTO();
        patientTO.setId(1L);
        patientTO.setFirstName("Grzegorz");
        patientTO.setLastName("Grzegorz");
        patientTO.setTelephoneNumber("2130073213");
        patientTO.setPatientNumber("XYZ111");
        patientTO.setDateOfBirth(LocalDate.of(2022, 5, 23));
        patientTO.setEmail("Grzegorz@example.com");
        patientTO.setPatientHistory("He's a pickle!");
        PatientEntity patientEntity = PatientMapper.mapToEntity(patientTO);
        assertNotNull(patientEntity);
        assertEquals(1L, patientEntity.getId());
        assertEquals("Grzegorz", patientEntity.getFirstName());
        assertEquals("Grzegorz", patientEntity.getLastName());
        assertEquals("2130073213", patientEntity.getTelephoneNumber());
        assertEquals("XYZ111", patientEntity.getPatientNumber());
        assertEquals("He's a pickle!", patientEntity.getPatientHistory());
        assertEquals("Grzegorz@example.com", patientEntity.getEmail());
        assertEquals(LocalDate.of(2022, 5, 23), patientEntity.getDateOfBirth());
    }
}
