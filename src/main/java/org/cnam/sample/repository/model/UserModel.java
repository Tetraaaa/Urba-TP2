package org.cnam.sample.repository.model;

import org.cnam.sample.domain.entity.Account;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "accounts")
    private ArrayList<Account> accounts;

    public UserModel() {
        this.accounts = new ArrayList<Account>();
    }

    public UserModel(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.accounts = new ArrayList<Account>();
    }

    public UserModel(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.accounts = new ArrayList<Account>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        if(!this.accounts.contains(account)) {
            this.accounts.add(account);
        }
    }

    public void removeAccount(Account account) {
        if(this.accounts.contains(account)) {
            this.accounts.remove(account);
        }
    }
}
