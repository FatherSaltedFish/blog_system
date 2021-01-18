package com.example.demo.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Service;
import java.net.http.HttpRequest;

@Controller
@EnableAutoConfiguration
@RequestMapping("/blog")
public class BlogController {
    @Resource
    private com.example.demo.service.BlogService blogService;
    @Resource
    private com.example.demo.service.CommentService commentService;
    @Resource
    private com.example.demo.service.SeeTimeService seeTimeService;
    @RequestMapping("")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("BlogList",blogService.selectAll());
        modelMap.addAttribute("opttype","main");
        return  "blog";
    }

    @RequestMapping("/showblog")
    public String showblog(@RequestParam(value="id")Integer id, HttpServletRequest request,ModelMap modelMap){
        if(id!=null)
            seeTimeService.insert(0,id);
        modelMap.addAttribute("Blog",blogService.selectByPrimaryKey(id));
        modelMap.addAttribute("CommentList",commentService.selectByblogid(id));
        modelMap.addAttribute("opttype","showblog");
        return "blog";
    }
}
