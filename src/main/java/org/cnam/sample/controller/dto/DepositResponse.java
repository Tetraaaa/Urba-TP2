package org.cnam.sample.controller.dto;

import org.cnam.sample.domain.entity.Account;
import org.cnam.sample.domain.entity.User;

public class DepositResponse {
    public Long id;

    public Long amount;

    public User depositaire;

    public Account account;

    public DepositResponse(Long id, Long amount, User depositaire, Account account) {
        this.id = id;
        this.amount = amount;
        this.depositaire = depositaire;
        this.account = account;
    }
}
