package com.example.demo.model;

import java.util.Date;

public class Comment {
    Integer id;
    Integer blogid;
    Date created;
    Integer userid;
    String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBlogid() {
        return blogid;
    }

    public void setBlogid(Integer blogid) {
        this.blogid = blogid;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Comment() {
    }

    public Comment(Integer id, Integer blogid, Date created, Integer userid, String content) {
        this.id = id;
        this.blogid = blogid;
        this.created = created;
        this.userid = userid;
        this.content = content;
    }
}
