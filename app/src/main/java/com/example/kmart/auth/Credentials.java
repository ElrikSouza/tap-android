package com.example.kmart.auth;

public class Credentials {
    private String username;
    private String password;

    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEquals(Credentials toBeTested) {
        return toBeTested.password.equals(password) && toBeTested.username.equals(username);
    }
}
