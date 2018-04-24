package com.redhat.developers;

public class Person {

    private final String title;

    private final String name;

    private final String surname;

    private final String prefix;

    private Person(Builder builder) {
        this.title = builder.title;
        this.name = builder.name;
        this.surname = builder.surname;
        this.prefix = builder.prefix;
    }

    public static Builder builder(String name, String surname) {
        return new Builder(name, surname);
    }

    public static class Builder {
        private String title;

        private final String name;

        private final String surname;

        private String prefix;

        private Builder(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder prefix(String prefix) {
            this.prefix = prefix;
            return this;
        }

        public Person build() {
            return new Person(this);
        }

    }

}
