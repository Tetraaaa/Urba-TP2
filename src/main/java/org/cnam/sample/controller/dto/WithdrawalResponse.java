package org.cnam.sample.controller.dto;

import org.cnam.sample.domain.entity.Account;
import org.cnam.sample.domain.entity.User;

public class WithdrawalResponse {
    public Long id;

    public Long amount;

    public Account beneficiaire;

    public Account account;

    public WithdrawalResponse(Long id, Long amount, Account beneficiaire, Account account) {
        this.id = id;
        this.amount = amount;
        this.beneficiaire = beneficiaire;
        this.account = account;
    }
}
