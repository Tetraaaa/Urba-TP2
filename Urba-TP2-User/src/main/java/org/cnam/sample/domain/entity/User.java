package org.cnam.sample.domain.entity;

import org.cnam.sample.repository.model.UserModel;

import java.util.ArrayList;

public class User {

    public Long id;

    public String lastname;

    public String firstname;

    public User(UserModel userModel)
    {
        this.id = userModel.getId();
        this.firstname = userModel.getFirstname();
        this.lastname = userModel.getLastname();
    }

    public User(Long id, String firstname, String lastname) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
    }
}
