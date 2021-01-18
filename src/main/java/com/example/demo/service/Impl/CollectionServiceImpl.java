package com.example.demo.service.Impl;

import com.example.demo.service.CollectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("CollectionService")
public class CollectionServiceImpl implements CollectionService {
    @Resource
    private com.example.demo.repository.CollectionMapper collectionMapper;
    @Override
    public Integer selectCollectionNumber(Integer blogid) {
        return collectionMapper.selectCollectionNumber(blogid);
    }

    @Override
    public void insert(Integer userid, Integer blogid) {
        collectionMapper.insert(userid,blogid);
    }

    @Override
    public Integer selectByPrimaryKey(Integer userid, Integer blogid) {
        return collectionMapper.selectByPrimaryKey(userid, blogid);
    }

    @Override
    public void deleteByPrimaryKey(Integer userid, Integer blogid) {
        collectionMapper.deleteByPrimaryKey(userid, blogid);
    }
}
