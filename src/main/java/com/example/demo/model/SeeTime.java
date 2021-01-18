package com.example.demo.model;

import java.util.Date;

public class SeeTime {
    Integer userid;
    Integer blogid;
    Date created;

    @Override
    public String toString() {
        return "SeeTime{" +
                "userid=" + userid +
                ", blogid=" + blogid +
                ", created=" + created +
                '}';
    }

    public SeeTime() {
    }

    public SeeTime(Integer userid, Integer blogid, Date created) {
        this.userid = userid;
        this.blogid = blogid;
        this.created = created;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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
}
