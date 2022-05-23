package com.jiuxiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * 登录控制器
 *
 * @author: WuDaoJiuXiao
 * @Date: 2022/05/22 16:50
 * @since: 1.0.0
 */
@Controller
public class LoginController {

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        Model model, HttpSession session) {
        //具体的业务，用户名、密码判断等业务 -> 此处简写
        if (username.equals("admin") && password.equals("123456")) {
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "用户名或密码错误!");
            return "index";
        }
    }

    /**
     * 用户注销
     *
     * @param session
     * @return
     */
    @RequestMapping("/user/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loginUser");
        return "index";
    }
}