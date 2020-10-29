package org.cnam.sample.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountToCreateRequest {

    public String data;

    @JsonCreator
    public AccountToCreateRequest(@JsonProperty("data") String data) {
        this.data = data;
    }
}
