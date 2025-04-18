package com.project.onlineTeach.entity;

import java.util.Objects;

public class Account {

   private Integer accId ;
    private String username;
    private  String password ;
    private String avatar;
    private   Integer type;

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accId=" + accId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accId, account.accId) && Objects.equals(username, account.username) && Objects.equals(password, account.password) && Objects.equals(avatar, account.avatar) && Objects.equals(type, account.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accId, username, password, avatar, type);
    }
}
