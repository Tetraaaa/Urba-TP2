package org.cnam.sample.repository.model;

import org.cnam.sample.domain.entity.Account;
import org.cnam.sample.domain.entity.User;

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

    //@OneToMany( targetEntity=AccountModel.class, mappedBy="user" )
    //private List<Command> commands = new ArrayList<>();

    public UserModel() {}

    public UserModel(User user) {
        this.id = user.id;
        this.firstname = user.firstname;
        this.lastname = user.lastname;
    }

    public UserModel(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public UserModel(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
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
}
