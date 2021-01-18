package com.example.demo.model;

public class LikeList {
    Integer userid;
    Integer commentid;

    @Override
    public String toString() {
        return "LikeList{" +
                "userid=" + userid +
                ", commentid=" + commentid +
                '}';
    }

    public LikeList() {
    }

    public LikeList(Integer userid, Integer commentid) {
        this.userid = userid;
        this.commentid = commentid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }
}
