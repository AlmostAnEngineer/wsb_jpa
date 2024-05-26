package com.test.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = VisitMapperTest.class)
public class VisitMapperTest {

    @Test
    public void EntityToTOTest()
    {
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(1L);
        visitEntity.setDescription("ddd");
        visitEntity.setTime(LocalDate.now().atStartOfDay());

        VisitTO visitTO = VisitMapper.mapToTO(visitEntity);
        assertEquals(visitEntity.getId(), visitTO.getId());
        assertEquals(visitEntity.getDescription(), visitTO.getDescription());
        assertEquals(visitEntity.getTime(), visitTO.getTime());
    }

    @Test
    public void TOToEntityTest()
    {
        VisitTO visitTO = new VisitTO();
        visitTO.setId(1L);
        visitTO.setDescription("ddd");
        visitTO.setTime(LocalDate.now().atStartOfDay());

        VisitEntity visitEntity = VisitMapper.TOtoMap(visitTO);
        assertEquals(visitEntity.getId(), visitTO.getId());
        assertEquals(visitEntity.getDescription(), visitTO.getDescription());
        assertEquals(visitEntity.getTime(), visitTO.getTime());
    }
}
