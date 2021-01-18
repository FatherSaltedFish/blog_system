package com.example.demo.service;

import com.example.demo.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> selectByblogid(Integer blogid);

    void  deleteByblogid(Integer blogid);

    void deleteByPrimaryKey(Integer id);

    void saveComment(Integer blogid,Integer id,String content);
}
