package org.cnam.sample.domain.entity;

import javax.persistence.Column;

public class Account {

    public Long id;

    public String data;

    public Account(Long id, String data) {
        this.id = id;
        this.data = data;
    }

}
