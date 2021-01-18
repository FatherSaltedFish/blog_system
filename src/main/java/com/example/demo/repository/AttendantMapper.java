package com.example.demo.repository;

import com.example.demo.model.Attendant;

public interface AttendantMapper {
     Attendant selectByPrimaryKey(String idno);
}
