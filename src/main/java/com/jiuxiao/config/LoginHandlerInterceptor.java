package com.jiuxiao.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 *
 * @author: WuDaoJiuXiao
 * @Date: 2022/05/22 17:37
 * @since: 1.0.0
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登陆成功之后，应该有用户的 session
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser == null){ //没有登录，不放行
            request.setAttribute("msg", "没有权限，请先登录!");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        }else{
            return true;
        }
    }
}