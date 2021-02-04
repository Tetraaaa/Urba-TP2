package org.cnam.sample.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.cnam.sample.domain.entity.User;

public class AccountToCreateRequest {

    public Long money;

    public User user;

    @JsonCreator
    public AccountToCreateRequest(@JsonProperty("money") Long money, @JsonProperty("user") User user) {
        this.money = money;
        this.user = user;
    }
}
