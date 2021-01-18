package com.example.demo.service.Impl;

import com.example.demo.service.SeeTimeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("SeeTimeService")
public class SeeTimeServiceImpl implements SeeTimeService {
    @Resource
    private com.example.demo.repository.SeeTimeMapper seeTimeMapper;

    @Override
    public void insert(Integer userid, Integer blogid) {
        seeTimeMapper.insert(userid, blogid);
    }

    @Override
    public Integer selectByblogid(Integer blogid) {
        return seeTimeMapper.selectByblogid(blogid);
    }
}
