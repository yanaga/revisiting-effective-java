package com.redhat.developers;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Optional;

public class BusinessEntity implements Serializable {

    private final Optional<String> name;

    private BusinessEntity(Optional<String> name) {
        this.name = name;
    }

    public static BusinessEntity of(String name) {
        return new BusinessEntity(Optional.ofNullable(name));
    }

    public Optional<String> getName() {
        return name;
    }

    public static void main(String[] args) {
        Optional<String> yanaga = BusinessEntity.of("Yanaga").getName();
        yanaga.ifPresent(s -> System.out.println(s));
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        throw new InvalidObjectException("Proxy required");
    }

    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    private static class SerializationProxy implements Serializable {

        private final String name;

        SerializationProxy(BusinessEntity entity) {
            this.name = entity.getName().orElse(null);
        }

        private Object readResolve() {
            return BusinessEntity.of(name);
        }
    }
}
