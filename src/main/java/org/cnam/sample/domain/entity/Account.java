package org.cnam.sample.domain.entity;

import javax.persistence.Column;

public class Account {

    public Long id;

    public Long money;

    public Account(Long id, Long money) {
        this.id = id;
        this.money = money;
    }

}
