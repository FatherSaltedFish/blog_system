package com.example.demo.controller;

import com.example.demo.model.Message;
import com.example.demo.service.MessageService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@EnableAutoConfiguration
@Controller
public class IndexController {
    @RequestMapping("/")
    public static String index(HttpServletRequest request){
//        request.getSession().removeAttribute("idno");
//        request.getSession().removeAttribute("user");
//        request.getSession().removeAttribute("attendant");
        request.getSession().invalidate();
        return "index";
    }

    @Resource
    private MessageService messageService;
    @RequestMapping("/user_message")
    public String user_message(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email
            , @RequestParam(value = "message") String user_message, ModelMap modelMap){
        Message message=new Message();
        message.setName(name);
        message.setMessage(user_message);
        message.setEmail(email);
        modelMap.addAttribute("tof",this.messageService.insert_message(message));
        return ("redirect:/");
    }
}
