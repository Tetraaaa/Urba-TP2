package org.cnam.sample.domain.entity;

import java.util.ArrayList;

public class User {

    public Long id;

    public String lastname;

    public String firstname;

    public User(Long id, String firstname, String lastname) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
    }
}
