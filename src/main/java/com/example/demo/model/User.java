package com.example.demo.model;

public class User {
    String username;
    Integer userid;
    String pwd;
    String tel;
    String email;
    Integer picid;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", userid=" + userid +
                ", pwd='" + pwd + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", picid=" + picid +
                '}';
    }

    public Integer getPicid() {
        return picid;
    }

    public void setPicid(Integer picid) {
        this.picid = picid;
    }

    public User(String username, Integer userid, String pwd, String tel, String email, Integer picid) {
        this.username = username;
        this.userid = userid;
        this.pwd = pwd;
        this.tel = tel;
        this.email = email;
        this.picid=picid;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
