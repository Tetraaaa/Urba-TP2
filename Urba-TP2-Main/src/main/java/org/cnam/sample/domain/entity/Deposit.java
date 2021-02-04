package org.cnam.sample.domain.entity;

import org.cnam.sample.repository.model.DepositModel;

public class Deposit {

    public Long id;

    public Long amount;

    public User depositaire;

    public Account account;

    public Deposit(Long id, Long amount, User depositaire, Account account) {
        this.id = id;
        this.amount = amount;
        this.depositaire = depositaire;
        this.account = account;
    }
}
