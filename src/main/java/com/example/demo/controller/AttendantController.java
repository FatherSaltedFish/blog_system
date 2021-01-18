package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@EnableAutoConfiguration
@RequestMapping("/attendant")
public class AttendantController {

    @Resource
    private com.example.demo.service.UserService userService;
    @Resource
    private com.example.demo.service.BlogService blogService;
    @Resource
    private com.example.demo.service.CommentService commentService;
    @Resource
    private com.example.demo.service.MessageService messageService;

    @RequestMapping(path={"","/managementblog"})
    public String index(ModelMap modelMap){
        modelMap.addAttribute("BlogList",blogService.selectAll());
        modelMap.addAttribute("opttype","main");
        return "attendant";
    }

    @RequestMapping("/managementmessage")
    public String managementmessage(ModelMap modelMap){
        modelMap.addAttribute("MessageList",messageService.selectAll());
        modelMap.addAttribute("opttype","managementmessage");
        return "attendant";
    }

    @RequestMapping("/managementuser")
    public String managementuser(ModelMap modelMap){
        modelMap.addAttribute("UserList",userService.selectAll());
        modelMap.addAttribute("opttype","managementuser");
        return "attendant";
    }

    @RequestMapping("/showblog")
    public String showblog(@RequestParam(value="id",required = false) Integer id,ModelMap modelMap){
        modelMap.addAttribute("Blog",blogService.selectByPrimaryKey(id));
        modelMap.addAttribute("CommentList",commentService.selectByblogid(id));
        modelMap.addAttribute("opttype","showblog");
        return "attendant";
    }

    @RequestMapping("/deleteuser")
    public String deleteuser(@RequestParam(value="id") Integer id){
        userService.deleteByuserid(id);
        return "redirect:/attendant/managementuser";
    }



    @RequestMapping(value = "/changepwd")
    public String changepwd(@RequestParam(value = "idno")Integer userid,@RequestParam(value = "pwd")String pwd){
        userService.changepwdByuserid(userid, pwd);
        return "redirect:/attendant/managementuser";
    }


    @RequestMapping("/deleteblog")
    public String deleteblog(@RequestParam("id")Integer id){
        blogService.deleteBlog(id);
        return "redirect:/attendant/";
    }

}
