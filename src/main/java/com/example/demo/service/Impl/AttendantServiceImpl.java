package com.example.demo.service.Impl;

import com.example.demo.model.Attendant;
import com.example.demo.repository.AttendantMapper;
import com.example.demo.service.AttendantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("attendantService")
public class AttendantServiceImpl implements AttendantService {
    @Resource
    private AttendantMapper attendantMapper;
    @Override
    public Attendant getattendantByidno(String idno) {
        return attendantMapper.selectByPrimaryKey(idno);
    }
}
