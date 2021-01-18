package com.example.demo.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IPcheckInterceptor implements HandlerInterceptor { long start = System.currentTimeMillis();
    @Override public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if(httpServletResponse.getStatus() == 404)
        {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/notfind");
            System.out.println("wrong!!!!"+httpServletRequest.getServletPath());
            return false;
        }
//        String remoteAddr = httpServletRequest.getRemoteAddr();
//        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
//        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
//        Date date = new Date();
//        System.out.println(remoteAddr+" time "+sdf.format(date));
        return true;
    }

    @Override public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //System.out.println("Interceptor cost="+(System.currentTimeMillis()-start));
    }

    @Override public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
