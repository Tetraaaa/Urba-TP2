package org.cnam.sample.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.cnam.sample.domain.entity.Account;
import org.cnam.sample.domain.entity.User;

public class WithdrawalToCreateRequest {
    public Long amount;

    public Account beneficiaire;

    public Account account;

    @JsonCreator
    public WithdrawalToCreateRequest(@JsonProperty("amount") Long amount, @JsonProperty("beneficiaire") Account beneficiaire, @JsonProperty("account") Account account) {
        this.amount = amount;
        this.beneficiaire = beneficiaire;
        this.account = account;
    }
}
