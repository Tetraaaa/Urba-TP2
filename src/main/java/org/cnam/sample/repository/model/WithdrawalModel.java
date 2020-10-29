package org.cnam.sample.repository.model;

import org.cnam.sample.domain.entity.Account;
import org.cnam.sample.domain.entity.User;

import javax.persistence.*;

@Entity

@Table(name = "Withdrawal")
public class WithdrawalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "amount")
    private Long amount;

    @ManyToOne
    @JoinColumn( name = "beneficiaire" , insertable = false, updatable = false)
    private UserModel beneficiaire;

    @ManyToOne
    @JoinColumn( name = "account" , insertable = false, updatable = false)
    private AccountModel account;

    public WithdrawalModel(){}

    public WithdrawalModel(Long amount, UserModel beneficiaire, AccountModel account) {
        this.amount = amount;
        this.beneficiaire = beneficiaire;
        this.account = account;
    }

    public WithdrawalModel(Long id, Long amount, UserModel beneficiaire, AccountModel account) {
        this.id = id;
        this.amount = amount;
        this.beneficiaire = beneficiaire;
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

    public UserModel getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(UserModel beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }
}
