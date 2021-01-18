package com.example.demo.controller;


import com.example.demo.model.Pic;
import com.example.demo.repository.LikeListMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;

@Controller
@EnableAutoConfiguration
public class GeneralController {
    @Resource
    com.example.demo.service.UserService userService;
    @Resource
    com.example.demo.service.BlogService blogService;
    @Resource
    com.example.demo.service.CommentService commentService;
    @Resource
    com.example.demo.service.CollectionService collectionService;
    @Resource
    LikeListMapper likeListMapper;
    @Resource
    com.example.demo.service.SeeTimeService seeTimeService;
    @Resource
    com.example.demo.service.PicService picService;

    @ResponseBody
    @RequestMapping("/checkemail")
    public boolean checkemail(@RequestParam(value = "email") String email){
        if(userService.getUserByemail(email)==null)
            return true;
        else
            return false;
    }
    @ResponseBody
    @RequestMapping("/checktel")
    public boolean checktel(@RequestParam(value = "tel") String tel){
        if(userService.getUserBytel(tel)==null &&Pattern.matches("\\d{11}",tel)){
            return true;
        }
        else
            return false;
    }

    @ResponseBody
    @RequestMapping("/getBlogContent")
    public String getBlogContent(@RequestParam(value = "id") Integer id){
        return blogService.selectByPrimaryKey(id).getContent();
    }

    @RequestMapping({"/nouser","/nouser1"})
    public String nouser(){
        return "nouser";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session=request.getSession();//获取session并将userName存入session对象
        session.invalidate();
        return "redirect:/";
    }
    @ResponseBody
    @RequestMapping("/getusername")
    public String getusername(@RequestParam(value = "id")Integer id){
        return userService.selectByPrimaryKey(id).getUsername();
    }

    @ResponseBody
    @RequestMapping("/deleteComment")
    public void deleteComment(@RequestParam(value = "id")Integer id){
        commentService.deleteByPrimaryKey(id);
    }

    @ResponseBody
    @RequestMapping("/saveComment")
    public void saveComment(@RequestParam(value = "content")String content,@RequestParam(value = "blogid")Integer blogid,HttpServletRequest request){
        Integer id= (Integer) request.getSession().getAttribute("idno");
        commentService.saveComment(blogid,id,content);
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @ResponseBody
    @RequestMapping("/addCollection")
    public Integer addCollection(@RequestParam(value = "BlogID")Integer BlogID,@RequestParam(value = "userid")Integer userid){
        collectionService.insert(userid,BlogID);
        return collectionService.selectCollectionNumber(BlogID);
    }

    @ResponseBody
    @RequestMapping("/checkCollection")
    public Boolean checkCollection(@RequestParam(value = "BlogID")Integer BlogID,@RequestParam(value = "userid")Integer userid){
        if (collectionService.selectByPrimaryKey(userid,BlogID)==0)
            return false;
        else
            return true;
    }

    @ResponseBody
    @RequestMapping("/deleteCollection")
    public Integer deleteCollection(@RequestParam(value = "BlogID")Integer BlogID,@RequestParam(value = "userid")Integer userid){
        collectionService.deleteByPrimaryKey(userid,BlogID);
        return collectionService.selectCollectionNumber(BlogID);
    }

    @ResponseBody
    @RequestMapping("/selectCollectionNumber")
    public Integer selectCollectionNumber(@RequestParam(value = "BlogID")Integer BlogID){
        return collectionService.selectCollectionNumber(BlogID);
    }

    @ResponseBody
    @RequestMapping("/selectLikeByPrimaryKey")
    public Boolean selectLikeByPrimaryKey(HttpServletRequest request,@RequestParam(value = "commentid")Integer commentid){
        if( likeListMapper.selectByPrimaryKey((Integer) request.getSession().getAttribute("idno"),commentid)==0){
            return false;
        }
        else
            return true;
    }

    @ResponseBody
    @RequestMapping("/insertlike")
    public Integer insertlike(HttpServletRequest request,@RequestParam(value = "commentid")Integer commentid){
         likeListMapper.insert((Integer) request.getSession().getAttribute("idno"),commentid);
        return likeListMapper.selectNumberBycommentid(commentid);
    }

    @ResponseBody
    @RequestMapping("/deletelike")
    public Integer deletelike(HttpServletRequest request,@RequestParam(value = "commentid")Integer commentid){
        likeListMapper.delete((Integer) request.getSession().getAttribute("idno"),commentid);
        return likeListMapper.selectNumberBycommentid(commentid);
    }

    @ResponseBody
    @RequestMapping("/selectlikeNumber")
    public Integer selectlikeNumber(HttpServletRequest request,@RequestParam(value = "commentid")Integer commentid){
        return likeListMapper.selectNumberBycommentid(commentid);
    }

    @RequestMapping("/notfind")
    public String  nofind(){
        return "404";
    }

    @ResponseBody
    @RequestMapping("/selectseenumber")
    public Integer selectseenumber(@RequestParam(value = "blogid")Integer blogid){
        return seeTimeService.selectByblogid(blogid);
    }

    @ResponseBody
    @GetMapping(value="/getPic")
    public void getPic(final HttpServletResponse response, @RequestParam(value = "id")Integer id) throws IOException {
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

}
