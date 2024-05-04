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
        List<PatientEntity> patients;
        patients = entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.lastName LIKE :lastName"
                , PatientEntity.class)
                .setParameter("lastName", "%" + lastName + "%")
                .getResultList();
        return patients;
    }
}
