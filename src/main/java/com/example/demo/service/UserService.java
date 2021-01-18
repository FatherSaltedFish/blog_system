package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    User selectByPrimaryKey(Integer idno);

    User getUserBytel(String tel);

    void addUser(User user);

    User getUserByemail(String email);

    List<User> selectAll();

    void changepwdByuserid(Integer userid,String pwd);

    void deleteByuserid(Integer userid);

    void changepic(Integer userid,Integer picid);


}
