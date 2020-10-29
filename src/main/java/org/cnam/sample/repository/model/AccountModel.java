package org.cnam.sample.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "sample")
public class AccountModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "money")
    private Long money;

    public AccountModel() {
    }

    public AccountModel(Long money) {
        this.money = money;
    }

    public AccountModel(Long id, Long money) {
        this.id = id;
        this.money = money;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }
}
