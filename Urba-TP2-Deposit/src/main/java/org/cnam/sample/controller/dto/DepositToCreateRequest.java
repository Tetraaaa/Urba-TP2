package org.cnam.sample.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

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
