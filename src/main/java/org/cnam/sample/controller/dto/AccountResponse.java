package org.cnam.sample.controller.dto;

public class AccountResponse {

    public Long id;

    public Long money;

    public AccountResponse(Long id, Long money) {
        this.id = id;
        this.money = money;
    }
}
