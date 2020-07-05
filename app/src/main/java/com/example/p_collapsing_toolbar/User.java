package com.example.p_collapsing_toolbar;

public class User {
    private String account, password, id;

    public User(String account, String password, String id) {
        this.account = account;
        this.password = password;
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
