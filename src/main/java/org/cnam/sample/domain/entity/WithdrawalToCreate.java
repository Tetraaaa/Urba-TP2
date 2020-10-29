package org.cnam.sample.domain.entity;

import javax.persistence.Column;

public class WithdrawalToCreate {

    public Long amount;

    public User beneficiaire;

    public Account account;

    public WithdrawalToCreate(Long amount, User beneficiaire, Account account) {
        this.amount = amount;
        this.beneficiaire = beneficiaire;
        this.account = account;
    }
}
