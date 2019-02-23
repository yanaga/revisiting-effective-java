package com.redhat.developers;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static org.junit.Assert.*;

public class BusinessEntityTest {

    @Test
    public void testSerialization() throws Exception{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        BusinessEntity yanaga = BusinessEntity.of("Yanaga");
        oos.writeObject(yanaga);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object o = ois.readObject();
        assertTrue(o instanceof BusinessEntity);
        BusinessEntity entity = (BusinessEntity) o;
        assertEquals("Yanaga", entity.getName().get());
    }



}