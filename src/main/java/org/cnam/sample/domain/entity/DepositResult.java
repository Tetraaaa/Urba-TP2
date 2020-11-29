package org.cnam.sample.domain.entity;

public class DepositResult {

    public boolean ok;

    public Long id;

    public Long amount;

    public User depositaire;

    public Account account;

    public DepositResult(boolean ok, Long id, Long amount, User depositaire, Account account) {
        this.ok = ok;
        this.id = id;
        this.amount = amount;
        this.depositaire = depositaire;
        this.account = account;
    }
}
