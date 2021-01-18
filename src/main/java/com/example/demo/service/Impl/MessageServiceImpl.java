package com.example.demo.service.Impl;

import com.example.demo.model.Message;
import com.example.demo.repository.MessageMapper;
import com.example.demo.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageMapper messageMapper;

    @Override
    public boolean insert_message(Message message) {

        if(messageMapper.insert_message(message)==1)
            return true;
        else
            return false;
    }

    @Override
    public List<Message> selectAll() {
        return messageMapper.selectAll();
    }
}
