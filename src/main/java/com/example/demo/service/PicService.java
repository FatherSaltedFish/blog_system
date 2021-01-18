package com.example.demo.service;

import com.example.demo.model.Pic;

public interface PicService {
    Integer insert(Pic pic);

    Pic getPhotoById(Integer id);

}
