package org.cnam.sample.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "sample")
public class AccountModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "data")
    private String data;

    public AccountModel() {
    }

    public AccountModel(String data) {
        this.data = data;
    }

    public AccountModel(Long id, String data) {
        this.id = id;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
