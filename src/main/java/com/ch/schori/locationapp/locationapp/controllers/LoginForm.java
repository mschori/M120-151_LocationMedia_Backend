package com.ch.schori.locationapp.locationapp.controllers;

public class LoginForm {

    private Long id;
    private Boolean loginSuccessfull;

    public LoginForm(Long id, Boolean loginSuccessfull) {
        this.id = id;
        this.loginSuccessfull = loginSuccessfull;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getLoginSuccessfull() {
        return loginSuccessfull;
    }

    public void setLoginSuccessfull(Boolean loginSuccessfull) {
        this.loginSuccessfull = loginSuccessfull;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "id=" + id +
                ", loginSuccessfull=" + loginSuccessfull +
                '}';
    }
}
