package com.example.demo.service.Impl;

import com.example.demo.repository.LikeListMapper;
import com.example.demo.service.LikeListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("LikeListService")
public class LikeListServiceImpl implements LikeListService {
    @Resource
    private LikeListMapper likeListMapper;
    @Override
    public void insert(Integer userid, Integer commentid) {
        likeListMapper.insert(userid, commentid);
    }

    @Override
    public Integer selectNumberBycommentid(Integer commentid) {
        return likeListMapper.selectNumberBycommentid(commentid);
    }

    @Override
    public void delete(Integer userid, Integer commentid) {
        likeListMapper.delete(userid, commentid);
    }

    @Override
    public Integer selectByPrimaryKey(Integer userid, Integer commentid) {
        return likeListMapper.selectByPrimaryKey(userid, commentid);
    }
}
