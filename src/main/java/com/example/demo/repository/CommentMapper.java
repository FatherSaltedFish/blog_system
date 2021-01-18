package com.example.demo.repository;

import com.example.demo.model.Comment;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface CommentMapper {
    List<Comment> selectByblogid(Integer blogid);

    void  deleteByblogid(Integer blogid);

    void deleteByPrimaryKey(Integer id);

    void saveComment(Integer blogid,Integer userid,String content);
}
