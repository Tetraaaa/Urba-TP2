package org.cnam.sample.domain.entity;

public class AccountToCreate {

    public Long money;

    public User user;

    public AccountToCreate(Long money, User user) {
        this.money = money;
        this.user = user;
    }
}
