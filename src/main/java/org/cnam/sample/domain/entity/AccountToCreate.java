package org.cnam.sample.domain.entity;

import javax.persistence.Column;

public class AccountToCreate {

    public Long money;

    public User user;

    public AccountToCreate(Long money, User user) {
        this.money = money;
        this.user = user;
    }
}
