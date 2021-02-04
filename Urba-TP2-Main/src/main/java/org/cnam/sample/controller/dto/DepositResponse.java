package org.cnam.sample.controller.dto;

import org.cnam.sample.domain.entity.Account;
import org.cnam.sample.domain.entity.User;

public class DepositResponse {
    public boolean ok;

    public Long id;

    public Long amount;

    public User depositaire;

    public Account account;

    public DepositResponse(boolean ok, Long id, Long amount, User depositaire, Account account) {
        this.ok = ok;
        this.id = id;
        this.amount = amount;
        this.depositaire = depositaire;
        this.account = account;
    }
}
