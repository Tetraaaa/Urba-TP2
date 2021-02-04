package org.cnam.sample.domain.entity;

public class WithdrawalResult {

    public boolean ok;

    public Long id;

    public Long amount;

    public Account beneficiaire;

    public Account account;

    public WithdrawalResult(boolean ok, Long id, Long amount, Account beneficiaire, Account account) {
        this.id = id;
        this.ok = ok;
        this.amount = amount;
        this.beneficiaire = beneficiaire;
        this.account = account;
    }
}
