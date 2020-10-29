package org.cnam.sample.controller.dto;

public class UserResponse {

    public Long id;

    public String firstname;

    public String lastname;

    public UserResponse(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
