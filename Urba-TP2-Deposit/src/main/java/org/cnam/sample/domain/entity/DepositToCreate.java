package org.cnam.sample.domain.entity;

public class DepositToCreate {

    public Long amount;

    public User depositaire;

    public Account account;

    public DepositToCreate(Long amount, User depositaire, Account account) {
        this.amount = amount;
        this.depositaire = depositaire;
        this.account = account;
    }
}
