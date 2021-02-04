package org.cnam.sample.domain.entity;

public class UserResult {

    public boolean ok;

    public Long id;

    public String lastname;

    public String firstname;

    public UserResult(boolean ok, Long id, String lastname, String firstname) {
        this.ok = ok;
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
    }
}
