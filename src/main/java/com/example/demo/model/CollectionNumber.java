package com.example.demo.model;

public class CollectionNumber {
    Integer userid;
    Integer blogid;

    public CollectionNumber() {
    }

    public CollectionNumber(Integer blogid) {
        this.blogid = blogid;
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

    @Override
    public String toString() {
        return "CollectionNumber{" +
                "userid=" + userid +
                ", blogid=" + blogid +
                '}';
    }
}
