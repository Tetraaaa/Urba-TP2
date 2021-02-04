package org.cnam.sample.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserToCreateRequest {

    public String lastname;

    public String firstname;

    @JsonCreator
    public UserToCreateRequest(@JsonProperty("firstname") String firstname, @JsonProperty("lastname") String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
