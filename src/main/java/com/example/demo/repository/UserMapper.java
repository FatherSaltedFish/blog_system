package com.example.demo.repository;

import com.example.demo.model.User;

import java.util.List;

public interface UserMapper {

   User selectByPrimaryKey(Integer idno);

   User getUserBytel(String tel);

   User getUserByemail(String email);

   List<User> selectAll();

   void addUser(User user);

   void changepwdByuserid(Integer userid,String pwd);

   void deleteByuserid(Integer userid);

   void changepic(Integer userid,Integer picid);

}
