package org.cnam.sample.repository.model;

import javax.persistence.*;

@Entity

@Table(name = "Account")
public class AccountModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "money")
    private Long money;

    @ManyToOne
    @JoinColumn( name = "userId" , insertable = false, updatable = true)
    private UserModel user;

    public AccountModel() {
    }

    public AccountModel(Long money, UserModel user) {
        this.money = money;
        this.user = user;
    }

    public AccountModel(Long id, Long money, UserModel user) {
        this.id = id;
        this.money = money;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
