package org.cnam.sample.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountToCreateRequest {

    public Long money;

    @JsonCreator
    public AccountToCreateRequest(@JsonProperty("money") Long money) {
        this.money = money;
    }
}
