package com.test.capgemini.wsb.service;

import com.capgemini.wsb.WsbJpaApplication;
import com.capgemini.wsb.service.DoctorService;
import com.capgemini.wsb.service.VisitService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WsbJpaApplication.class)
public class VisitServiceTest {
    @Autowired
    private VisitService visitService;

    @Test
    @Transactional
    public void testShoudReturnDoctorById() {
        visitService.findById(1L);
        assertThat(visitService.findById(1L)).isNotNull();
        assertThat(visitService.findById(2L)).isNotNull();
        assertThat(visitService.findById(1000L)).isNull();
    }
}