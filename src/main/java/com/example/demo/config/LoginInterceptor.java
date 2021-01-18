package com.example.demo.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor { long start = System.currentTimeMillis();
    @Override public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Object user_id=httpServletRequest.getSession().getAttribute("idno");
        if(user_id==null){
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/nouser");
            System.out.println("wrong!!!!"+httpServletRequest.getServletPath());
            return false;
        }
        start = System.currentTimeMillis();
        String remoteAddr = httpServletRequest.getRemoteAddr();
        System.out.println("用户:"+user_id+"IP地址:"+remoteAddr+"拦截器访问方法："+httpServletRequest.getServletPath());
        return true;
    }

    @Override public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //System.out.println("Interceptor cost="+(System.currentTimeMillis()-start));
    }

    @Override public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
