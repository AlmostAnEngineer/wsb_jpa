package com.test.capgemini.wsb.mapper;


import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.mapper.AddressMapper;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = AdressMapperTest.class)
public class AdressMapperTest {

    @Test
    public void EntityToTO() {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(1L);
        addressEntity.setAddressLine1("a");
        addressEntity.setAddressLine2("b");
        addressEntity.setCity("a");
        addressEntity.setPostalCode("222");

        AddressTO addressTO = AddressMapper.mapToTO(addressEntity);
        assertEquals(addressEntity.getAddressLine1(), addressTO.getAddressLine1());
        assertEquals(addressEntity.getAddressLine2(), addressTO.getAddressLine2());
        assertEquals(addressEntity.getCity(), addressTO.getCity());
        assertEquals(addressEntity.getPostalCode(), addressTO.getPostalCode());
        assertEquals(addressEntity.getId(), addressTO.getId());
    }

    @Test
    public void TOToEntity()
    {
        AddressTO addressTO = new AddressTO();
        addressTO.setAddressLine1("a");
        addressTO.setAddressLine2("b");
        addressTO.setCity("a");
        addressTO.setPostalCode("222");
        AddressEntity addressEntity = AddressMapper.mapToEntity(addressTO);
        assertEquals(addressEntity.getAddressLine1(), addressTO.getAddressLine1());
        assertEquals(addressEntity.getAddressLine2(), addressTO.getAddressLine2());
        assertEquals(addressEntity.getCity(), addressTO.getCity());
        assertEquals(addressEntity.getPostalCode(), addressTO.getPostalCode());
        assertEquals(addressEntity.getId(), addressTO.getId());
    }
}
