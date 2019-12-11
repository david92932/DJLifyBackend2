package com.djlify.demo.Models;

public class UserModel {

    String username;
    String password;
    String ID;

    UserModel(String username, String password, String ID) {

        this.username = username;
        this.password = password;
        this.ID = ID;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
