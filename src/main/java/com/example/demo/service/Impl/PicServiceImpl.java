package com.example.demo.service.Impl;

import com.example.demo.model.Pic;
import com.example.demo.service.PicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("PicService")
public class PicServiceImpl implements PicService {
    @Resource
    com.example.demo.repository.PicMapper picMapper;


    @Override
    public Integer insert(Pic pic) {
        return picMapper.insert(pic);
    }

    @Override
    public Pic getPhotoById(Integer id) {
        return picMapper.getPhotoById(id);
    }
}
