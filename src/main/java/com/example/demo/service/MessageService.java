package com.example.demo.service;

import com.example.demo.model.Message;

import java.util.List;

public interface MessageService {

    boolean insert_message(Message message);

    List<Message> selectAll();
}
