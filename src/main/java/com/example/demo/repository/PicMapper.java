package com.example.demo.repository;

import com.example.demo.model.Pic;

public interface PicMapper {
    Integer insert(Pic pic);

    Pic getPhotoById(Integer id);
}
