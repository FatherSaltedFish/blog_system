package com.example.demo.service.Impl;

import com.example.demo.model.Comment;
import com.example.demo.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("CommentService")
public class CommentServiceImpl implements CommentService {
    @Resource
    private com.example.demo.repository.CommentMapper commentMapper;

    @Override
    public List<Comment> selectByblogid(Integer blogid) {
        return commentMapper.selectByblogid(blogid);
    }

    @Override
    public void deleteByblogid(Integer blogid) {
        commentMapper.deleteByblogid(blogid);
    }

    @Override
    public void deleteByPrimaryKey(Integer id) {
        commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveComment(Integer blogid, Integer id, String content) {
        commentMapper.saveComment(blogid,id,content);
    }


}
