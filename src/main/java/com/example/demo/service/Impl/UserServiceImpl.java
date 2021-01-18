package com.example.demo.service.Impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper UserMapper;


    @Override
    public User selectByPrimaryKey(Integer idno) {
        return UserMapper.selectByPrimaryKey(idno);
    }

    @Override
    public User getUserBytel(String tel) {
        return UserMapper.getUserBytel(tel);
    }

    @Override
    public void addUser(User user) {
        UserMapper.addUser(user);
    }

    @Override
    public User getUserByemail(String email) {
        return UserMapper.getUserByemail(email);
    }

    @Override
    public List<User> selectAll() {
        return UserMapper.selectAll();
    }

    @Override
    public void changepwdByuserid(Integer userid, String pwd) {
        UserMapper.changepwdByuserid(userid, pwd);
    }

    @Override
    public void deleteByuserid(Integer userid) {
        UserMapper.deleteByuserid(userid);
    }

    @Override
    public void changepic(Integer userid, Integer picid) {
        UserMapper.changepic(userid, picid);
    }
}
