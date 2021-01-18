package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;

public interface BlogService {
    Blog selectByPrimaryKey(Integer id);

    List<Blog> selectAll();

    void insertBlog(String title,String content,Integer userid);

    void deleteBlog(Integer id);

    void changeblogforcontent(Integer id,String content);

    List<Blog> selectBlogByuserid(Integer userid);

    List<Blog> selectCollectionBlogByuserid(Integer userid);
}
