package org.cnam.sample.repository.model;

import org.cnam.sample.domain.entity.Account;
import org.cnam.sample.domain.entity.Deposit;
import org.cnam.sample.domain.entity.User;

import javax.persistence.*;

@Entity

@Table(name = "Deposit")
public class DepositModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "amount")
    private Long amount;

    @ManyToOne
    @JoinColumn( name = "depositaire" , insertable = false, updatable = false)
    private UserModel depositaire;

    @ManyToOne
    @JoinColumn( name = "account" , insertable = false, updatable = false)
    private AccountModel account;

    public DepositModel() { }

    public DepositModel(Long amount, UserModel depositaire, AccountModel account)
    {
        this.amount = amount;
        this.depositaire = depositaire;
        this.account = account;
    }

    public DepositModel(Long id, Long amount, UserModel depositaire, AccountModel account) {
        this.id = id;
        this.amount = amount;
        this.depositaire = depositaire;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public UserModel getDepositaire() {
        return depositaire;
    }

    public void setDepositaire(UserModel depositaire) {
        this.depositaire = depositaire;
    }

    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }
}
