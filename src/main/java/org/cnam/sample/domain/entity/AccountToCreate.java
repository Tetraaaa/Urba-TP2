package org.cnam.sample.domain.entity;

import javax.persistence.Column;

public class AccountToCreate {

    public Long money;

    public AccountToCreate(Long money) {
        this.money = money;
    }
}
