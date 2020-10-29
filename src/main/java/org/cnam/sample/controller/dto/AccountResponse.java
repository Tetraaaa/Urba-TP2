package org.cnam.sample.controller.dto;

import org.cnam.sample.domain.entity.User;

public class AccountResponse {

    public Long id;

    public Long money;

    public User user;

    public AccountResponse(Long id, Long money, User user) {
        this.id = id;
        this.money = money;
        this.user = user;
    }
}
