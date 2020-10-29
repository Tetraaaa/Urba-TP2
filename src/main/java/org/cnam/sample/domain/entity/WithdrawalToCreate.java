package org.cnam.sample.domain.entity;

import javax.persistence.Column;

public class WithdrawalToCreate {

    @Column(name = "amount")
    private Long amount;

    @Column(name = "beneficiaire")
    private User beneficiaire;

    @Column(name = "account")
    private Account account;

    public WithdrawalToCreate(Long amount, User beneficiaire, Account account) {
        this.amount = amount;
        this.beneficiaire = beneficiaire;
        this.account = account;
    }
}
