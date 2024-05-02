package com.capgemini.wsb.service;

import com.capgemini.wsb.WsbJpaApplication;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.PatientService;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.dto.PatientTO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest
{
    @Autowired
    private PatientService patientService;
    private PatientMapper patientMapper;
    private DoctorDao doctorDao;

    @Transactional
    @Test
    public void testShouldFindPatientById()
    {
        PatientTO patientTO = patientService.findById(1L);
        PatientEntity patientEntity = patientMapper.mapToEntity(patientTO);
        assertThat(patientEntity).isNotNull();
        assertThat(patientEntity.getId()).isEqualTo(1);
        assertThat(patientEntity.getLastName()).isEqualTo("Wong");
    }

    @DirtiesContext
    @Test
    public void testShouldRemovePatientVisits()
    {
        patientService.removePatientEntity(1L);
        PatientTO patientTO = patientService.findById(1L);
        PatientEntity patientEntity = patientMapper.mapToEntity(patientTO);
        assertThat(patientEntity).isNull();
        DoctorEntity doctorEntity = doctorDao.findOne(1L);
        assertThat(doctorEntity).isNotNull();
    }
}
