package org.cnam.sample.domain.entity;

import java.util.ArrayList;

public class UserToCreate {

    public String firstname;

    public String lastname;

    public ArrayList<Account> accounts;

    public UserToCreate(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
