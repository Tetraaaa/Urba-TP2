package org.cnam.sample.domain.entity;

public class WithdrawalToCreate {

    public Long amount;

    public Account beneficiaire;

    public Account account;

    public WithdrawalToCreate(Long amount, Account beneficiaire, Account account) {
        this.amount = amount;
        this.beneficiaire = beneficiaire;
        this.account = account;
    }
}
