package org.cnam.sample.controller.dto;

import org.cnam.sample.domain.entity.User;

public class AccountResponse {
    public boolean ok;

    public Long id;

    public Long money;

    public User user;

    public AccountResponse(boolean ok, Long id, Long money, User user) {
        this.ok = ok;
        this.id = id;
        this.money = money;
        this.user = user;
    }
}
