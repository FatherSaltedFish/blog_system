package com.example.demo.repository;

import com.example.demo.model.Message;

import java.util.List;

public interface MessageMapper {

    int insert_message(Message message);

    List<Message> selectAll();
}
