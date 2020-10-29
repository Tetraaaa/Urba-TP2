package org.cnam.sample.domain.entity;

import javax.persistence.Column;

public class Account {

    public Long id;

    public Long money;

    public User user;

    public Account(Long id, Long money, User user) {
        this.id = id;
        this.money = money;
        this.user = user;
    }

}
