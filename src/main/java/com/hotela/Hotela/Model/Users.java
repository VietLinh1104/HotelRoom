package com.hotela.Hotela.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String phoneNumber;
    private String fullname;
    private String password;

    public Users() {
    }

    public Users(int id, String email, String phoneNumber, String fullname, String password) {
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.fullname = fullname;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
