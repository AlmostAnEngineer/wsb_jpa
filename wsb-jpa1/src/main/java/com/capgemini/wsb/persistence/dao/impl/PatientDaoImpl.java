package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDaoImpl extends  AbstractDao<PatientEntity, Long> implements PatientDao
{
    @Override
    public List<PatientEntity> findByLastName(String lastName)
    {
        List<PatientEntity> patients;;
        patients = entityManager.createQuery("SELECT p FROM PatientEntity p " +
                                "WHERE p.lastName LIKE :lastName"
                , PatientEntity.class)
                .setParameter("lastName", "%" + lastName + "%")
                .getResultList();
        return patients;
    }

    @Override
    public List<PatientEntity> findPatientsWithMoreVisitsThan(Integer cnt)
    {
        List<PatientEntity> patients;
        patients = entityManager.createQuery("SELECT DISTINCT p FROM PatientEntity p " +
                        " JOIN p.visits v" +
                        " GROUP BY p HAVING COUNT(v) > :cnt", PatientEntity.class)
                .setParameter("cnt", (long) cnt)
                .getResultList();
        return patients;
    };

    @Override
    public List<PatientEntity> findPatientsWithSpecyficWordInHistory(String word)
    {
        List<PatientEntity> patients;
        patients = entityManager.createQuery("SELECT p FROM PatientEntity p " +
                                "WHERE p.patientHistory LIKE :word"
                        , PatientEntity.class)
                .setParameter("word", "%" + word + "%")
                .getResultList();
        return patients;
    }
}
