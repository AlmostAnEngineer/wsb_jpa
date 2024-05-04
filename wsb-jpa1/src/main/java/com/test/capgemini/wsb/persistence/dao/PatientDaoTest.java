package com.test.capgemini.wsb.persistence.dao;


import com.capgemini.wsb.WsbJpaApplication;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WsbJpaApplication.class)
public class PatientDaoTest
{
    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void shoudFindByLastNameTest()
    {
        List<PatientEntity> foundPatients = patientDao.findByLastName("Wong");
        assertThat(foundPatients).isNotNull();
        assertThat(foundPatients.size()).isEqualTo(1);
    }

    @Transactional
    @Test
    public void shoudGivePatientsWithMoreVisitsThanX()
    {
        List<PatientEntity> foundPatients = patientDao.findPatientsWithMoreVisitsThan(3);
        assertThat(foundPatients).isNotNull();
        assertThat(foundPatients).isEmpty();
    }

    @Transactional
    @Test
    public void shoudGivePatientsWithSpecificHistoryWord()
    {
        List<PatientEntity> foundPatients = patientDao.findPatientsWithSpecyficWordInHistory("ziemniaki");
        assertThat(foundPatients).isNotNull();
        assertThat(foundPatients).isEmpty();
        foundPatients = patientDao.findPatientsWithSpecyficWordInHistory("ogórki");
        assertThat(foundPatients).isNotNull();
        assertThat(foundPatients).isNotEmpty();
    }
}
