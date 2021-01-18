package com.example.demo.service;

public interface LikeListService {
    void insert(Integer userid,Integer commentid);

    Integer selectNumberBycommentid(Integer commentid);

    void delete(Integer userid,Integer commentid);

    Integer selectByPrimaryKey(Integer userid,Integer commentid);

}
