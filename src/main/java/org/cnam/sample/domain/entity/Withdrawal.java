package org.cnam.sample.domain.entity;

import javax.persistence.Column;

public class Withdrawal {
    public Long id;

    public Long amount;

    public User beneficiaire;

    public Account account;

    public Withdrawal(Long id, Long amount, User beneficiaire, Account account) {
        this.id = id;
        this.amount = amount;
        this.beneficiaire = beneficiaire;
        this.account = account;
    }
}
