package org.cnam.sample.domain.entity;

import javax.persistence.Column;

public class Withdrawal {
    private Long id;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "beneficiaire")
    private User beneficiaire;

    @Column(name = "account")
    private Account account;

    public Withdrawal(Long id, Long amount, User beneficiaire, Account account) {
        this.id = id;
        this.amount = amount;
        this.beneficiaire = beneficiaire;
        this.account = account;
    }
}
