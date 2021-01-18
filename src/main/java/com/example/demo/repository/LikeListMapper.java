package com.example.demo.repository;

import org.springframework.data.relational.core.sql.In;

public interface LikeListMapper {
    void insert(Integer userid,Integer commentid);

    Integer selectNumberBycommentid(Integer commentid);

    void delete(Integer userid,Integer commentid);

    Integer selectByPrimaryKey(Integer userid,Integer commentid);
}
