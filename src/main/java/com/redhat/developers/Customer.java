package com.redhat.developers;

import java.io.Serializable;
import java.util.Optional;

public class Customer implements Serializable  {

    /**
     *
     */
    private String title;


    public Optional<String> getTitle() {
        return Optional.ofNullable(title);
    }

}
