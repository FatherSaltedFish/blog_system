package com.example.demo.model;

import java.util.Date;

public class Blog {
    Integer id;
    String title;
    Date created;
    String content;
    Integer userid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Blog(Integer id, String title, Date created, String content, Integer userid) {
        this.id = id;
        this.title = title;
        this.created = created;
        this.content = content;
        this.userid = userid;
    }

    public Blog() {
    }
}
