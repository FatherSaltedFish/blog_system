package com.example.demo.service.Impl;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("BlogService")
public class BlogServiceImpl implements BlogService {
    @Resource
    private com.example.demo.repository.BlogMapper blogMapper;


    @Override
    public Blog selectByPrimaryKey(Integer id) {
        return blogMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Blog> selectAll() {
        return blogMapper.selectAll();
    }

    @Override
    public void insertBlog(String title, String content, Integer userid) {
        blogMapper.insertBlog(title,content,userid);
    }

    @Override
    public void deleteBlog(Integer id) {
        blogMapper.deleteBlog(id);
    }

    @Override
    public void changeblogforcontent(Integer id, String content) {
        blogMapper.changeblogforcontent(id, content);
    }

    @Override
    public List<Blog> selectBlogByuserid(Integer userid) {
       return blogMapper.selectBlogByuserid(userid);
    }

    @Override
    public List<Blog> selectCollectionBlogByuserid(Integer userid) {
        return blogMapper.selectCollectionBlogByuserid(userid);
    }
}
