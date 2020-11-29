package org.cnam.sample.controller.dto;

public class UserResponse {

    public boolean ok;

    public Long id;

    public String firstname;

    public String lastname;

    public UserResponse(boolean ok, Long id, String firstname, String lastname) {
        this.ok = ok;
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
