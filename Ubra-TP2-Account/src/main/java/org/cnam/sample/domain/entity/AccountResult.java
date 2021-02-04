package org.cnam.sample.domain.entity;

public class AccountResult {
    public boolean ok;

    public Long id;

    public Long money;

    public User user;

    public AccountResult(boolean ok, Long id, Long money, User user) {
        this.ok = ok;
        this.id = id;
        this.money = money;
        this.user = user;
    }
}
