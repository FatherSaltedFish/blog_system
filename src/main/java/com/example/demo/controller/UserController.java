package com.example.demo.controller;

import com.example.demo.model.Pic;
import com.example.demo.service.PicService;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject ;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Service;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;

@EnableAutoConfiguration
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private com.example.demo.service.BlogService blogService;
    @Resource
    private com.example.demo.service.CommentService commentService;
    @Resource
    private com.example.demo.service.SeeTimeService seeTimeService;
    @Resource
    private com.example.demo.service.PicService picService;
    @Resource
    private com.example.demo.service.UserService userService;

    @RequestMapping(path={"","/managementblog"})
    public String index(ModelMap modelMap){
        modelMap.addAttribute("BlogList",blogService.selectAll());
        modelMap.addAttribute("opttype","main");
        return "user";
    }

    @RequestMapping(value = "/addblog",method = RequestMethod.GET)
    public String addblog_GET(ModelMap modelMap){
        modelMap.addAttribute("opttype","addblog");
        return "user";
    }

    @ResponseBody
    @RequestMapping(value = "/addblog",method = RequestMethod.POST)
    public void addblog_POST(@RequestParam(value = "content")String content, @RequestParam(value = "title")String title,HttpServletRequest request,ModelMap modelMap){
        blogService.insertBlog(title,content,(Integer) request.getSession().getAttribute("idno"));
    }

    @RequestMapping("/showblog")
    public String showblog(HttpServletRequest request,@RequestParam(value="id",required = false) Integer id, ModelMap modelMap){
        if(id!=null)
            seeTimeService.insert((Integer) request.getSession().getAttribute("idno"),id);

        modelMap.addAttribute("Blog",blogService.selectByPrimaryKey(id));
        modelMap.addAttribute("CommentList",commentService.selectByblogid(id));
        modelMap.addAttribute("opttype","showblog");
        return "user";
    }

    @RequestMapping(path = "/changeblog",method = RequestMethod.GET)
    public String changeblog(@RequestParam(value = "id")Integer id,ModelMap modelMap){
        modelMap.addAttribute("Blog",blogService.selectByPrimaryKey(id));
        modelMap.addAttribute("opttype","changeblog");
        return "user";
    }

    @ResponseBody
    @RequestMapping(path = "/changeblog",method = RequestMethod.POST)
    public void changeblog_post(@RequestParam(value = "id")Integer id,@RequestParam(value = "content")String content,ModelMap modelMap){
        blogService.changeblogforcontent(id, content);
    }

    @RequestMapping("/information")
    public String infromation(HttpServletRequest request,ModelMap modelMap){
        modelMap.addAttribute("BlogList",blogService.selectBlogByuserid((Integer)request.getSession().getAttribute("idno")));
        modelMap.addAttribute("CollectionBlogList",blogService.selectCollectionBlogByuserid((Integer)request.getSession().getAttribute("idno")));
        modelMap.addAttribute("opttype","information");
        return "user";
    }
    //修改用户的picid
    @RequestMapping("/changpic")
    public String changpic(HttpServletRequest request,@RequestParam(value = "id")Integer picid){
        userService.changepic((Integer) request.getSession().getAttribute("idno"),picid);
        request.getSession().setAttribute("user",userService.selectByPrimaryKey((Integer) request.getSession().getAttribute("idno")));
        return "redirect:/user/information";
    }

    //上传图片并返回 picid
    @ResponseBody
    @RequestMapping("/upload")
    public JSONObject savePic(@RequestParam(value = "editormd-image-file") MultipartFile file, HttpServletResponse response) throws JSONException {
        JSONObject res = new JSONObject();
        if (file.isEmpty()) {
            res.put("success", 0);
            res.put("message", "图片不能为空");
            return res;
        }
        try {
            InputStream is = file.getInputStream();
            Pic u = new Pic();
            byte[] pic = new byte[(int)file.getSize()];
            is.read(pic);
            u.setPic(pic);
            picService.insert(u);
            res.put("url", "http://8.133.176.244:8080/getPic?id="+u.getId());
            res.put("success", 1);
            res.put("message", "success!");
            res.put("picid",String.valueOf(u.getId()));
            return res;
        } catch (IOException e) {
            e.printStackTrace();
            res.put("success",0);
            res.put("message",e);
        }
        return res;
    }
    //显示图片的数据流
    @ResponseBody
    @GetMapping(value="/getPic")
    public void getPic(final HttpServletResponse response,@RequestParam(value = "id")Integer id) throws IOException {
        Pic pic = picService.getPhotoById(id);
        byte[] data = pic.getPic();
        response.setContentType("image/jpeg");
        response.setCharacterEncoding("UTF-8");
        OutputStream outputSream = response.getOutputStream();
        InputStream in = new ByteArrayInputStream(data);
        int len = 0;
        byte[] buf = new byte[1024];
        while ((len = in.read(buf, 0, 1024)) != -1) {
            outputSream.write(buf, 0, len);
        }
        outputSream.close();
    }

    @RequestMapping("/deleteblog")
    public String deleteblog(@RequestParam("id")Integer id){
        blogService.deleteBlog(id);
        return "redirect:/user/information";
    }

    @RequestMapping(value = "/changepwd")
    public String changepwd(@RequestParam(value = "idno")Integer userid,@RequestParam(value = "pwd")String pwd){
        userService.changepwdByuserid(userid, pwd);
        return "redirect:/user/information";
    }
}
