package com.example.demo.controller;

import com.example.demo.model.Attendant;
import com.example.demo.model.User;
import com.example.demo.service.AttendantService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@EnableAutoConfiguration
@Controller
public class LoginController {

    @RequestMapping("/login")
    public static String login(HttpServletRequest request,ModelMap model){
        request.getSession().invalidate();
        model.addAttribute("model","login");
        model.addAttribute("ismember",false);
        model.addAttribute("goway","/login_myquestions");
        return "login";
    }

    @RequestMapping("/Clogin")
    public static String Clogin(HttpServletRequest request,ModelMap model){
        request.getSession().invalidate();
        model.addAttribute("model","Clogin");
        model.addAttribute("goway","/login_attendant");
        return "login";
    }

    @RequestMapping("/register")
    public static String register(HttpServletRequest request,ModelMap model){
        request.getSession().invalidate();
        model.addAttribute("model","register");
        model.addAttribute("goway","/addmember");
        return "login";
    }

    @Resource
    private com.example.demo.service.UserService userService;

    @RequestMapping("/addmember")
    public String addmember(@RequestParam(value = "tel") String tel, @RequestParam(value = "pwd") String pwd,
                            @RequestParam(value = "username") String username, @RequestParam(value = "email") String email, HttpServletRequest request, ModelMap model){
        HttpSession session=request.getSession();//获取session并将userName存入session对象
        Object test=this.userService.getUserBytel(tel);
        if(test!=null){
            model.addAttribute("model","register");
            model.addAttribute("goway","/addmember");
            model.addAttribute("ismember",true);
            model.addAttribute("wrong","电话或邮箱已使用");
            return "login";
        }
        User user = new User();
        user.setTel(tel);
        user.setUsername(username);
        user.setPwd(pwd);
        user.setEmail(email);
        this.userService.addUser(user);
        Object test1=this.userService.getUserBytel(tel);
        user = (User) test1;
//        session.setAttribute("userName", user.getUsername());
//        session.setAttribute("idno", user.getUserid());
        session.setAttribute("user", user);
        session.setAttribute("idno",user.getUserid());
//        System.out.println("用户ID:"+user.getUserid()+"注册登录");
        return "redirect:/user";
    }

    @RequestMapping(path = {"/login_myquestions/","/login_myquestions"})
    public  String member_index(@RequestParam(value="tel",required = false) String tel, @RequestParam(value="pwd",required = false) String pwd,HttpServletRequest request,ModelMap model){
        Object test=this.userService.getUserBytel(tel);
        HttpSession session=request.getSession();//获取session并将userName存入session对象
        if(test==null){
            model.addAttribute("model","login");
            model.addAttribute("ismember",true);
            model.addAttribute("wrong","账号未注册，请注册");
            model.addAttribute("goway","/login_myquestions");
            return "login";
        }
        User user = (User) test;
        if(user.getPwd().equals(pwd)){
//            session.setAttribute("userName", user.getUsername());
//            session.setAttribute("idno", user.getUserid());
            session.setAttribute("user",user);
            session.setAttribute("idno",user.getUserid());
//            System.out.println("用户ID:"+user.getUserid()+"登录");
//            model.addAttribute("member",member);
//            model.addAttribute("opttype","main");
////            String string =stringRedisTemplate.opsForValue().get("aaa");
        }
        else {
            model.addAttribute("model","login");
            model.addAttribute("ismember",true);
            model.addAttribute("wrong","手机号或密码错误");
            model.addAttribute("goway","/login_myquestions");
            return "login";
        }
        return "redirect:/user";
    }

    @Resource
    private AttendantService attendantService;

    @RequestMapping(path={"/login_attendant","/login_attendant/"})//登录传递
    public  String attendant_index(@RequestParam(value="tel",required = false) String idno, @RequestParam(value="pwd",required = false) String pwd, HttpServletRequest request, ModelMap model){
        Object test=this.attendantService.getattendantByidno(idno);
        HttpSession session=request.getSession();
        if(test==null){
            model.addAttribute("model","Clogin");
            model.addAttribute("ismember",true);
            model.addAttribute("wrong","账号非管理员账号");
            model.addAttribute("goway","/login_attendant");
            return "login";
        }
        Attendant attendant = (Attendant)test;
        if(attendant.getPwd().equals(pwd)){
//            session.setAttribute("attendantName", attendant.getUsername());
//            session.setAttribute("idno",attendant.getIdno());
            session.setAttribute("attendant",attendant);
            session.setAttribute("idno",attendant.getIdno());
//            System.out.println("管理员ID:"+attendant.getIdno()+"登录");
//            model.addAttribute("Attendant",Attendant);
//            model.addAttribute("opttype","main");
        }
        else {
            model.addAttribute("model","Clogin");
            model.addAttribute("ismember",true);
            model.addAttribute("wrong","账号或密码错误");
            model.addAttribute("goway","/login_attendant");
            return "login";
        }
        return "redirect:/attendant";
    }
}
