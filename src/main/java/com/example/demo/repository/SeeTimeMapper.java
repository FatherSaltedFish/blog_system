package com.example.demo.repository;

import org.springframework.data.relational.core.sql.In;

public interface SeeTimeMapper {

    void insert(Integer userid,Integer blogid);

    Integer selectByblogid(Integer blogid);
}
