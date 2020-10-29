package org.cnam.sample.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.cnam.sample.domain.entity.Account;
import org.cnam.sample.domain.entity.User;

public class DepositToCreateRequest {

    public Long amount;

    public User depositaire;

    public Account account;

    @JsonCreator
    public DepositToCreateRequest(@JsonProperty("amount") Long amount, @JsonProperty("depositaire") User depositaire, @JsonProperty("account") Account account) {
        this.amount = amount;
        this.depositaire = depositaire;
        this.account = account;
    }
}
