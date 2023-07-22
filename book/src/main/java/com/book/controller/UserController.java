package com.book.controller;

import com.book.entity.Books;
import com.book.entity.User;
import com.book.service.BooksService;
import com.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户控制类
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("BooksServiceImpl")
    private BooksService booksService;


    @RequestMapping("login")
    public String login(Model md,HttpServletRequest request){
        md.addAttribute("role",request.getSession().getAttribute("role"));
        return "index";
    }

    @RequestMapping("register")
    public String register(){
         return "register";
    }

    @RequestMapping("book")
    public String book(){
        return "book";
    }

    @RequestMapping("loginUser")
    public String loginUser(){
        return "login";
    }

    @RequestMapping("islogin")
    @ResponseBody
    public String islogin(HttpServletRequest http,String account, String password){
        String pwd = userService.queryByname(account);
        if(pwd==null||!pwd.equals(password))
            return "error";
        //验证成功，记录Session信息
        http.getSession().setAttribute("account", account);
        http.getSession().setAttribute("role",userService.getRole(account));
        return "success";
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest http){
        //删除Session信息
        http.getSession().removeAttribute("account");
        http.getSession().invalidate();
        return "login";
    }

    @RequestMapping("isregister")
    @ResponseBody
    public String isRegister(String account,String password){
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setRole(0);
//        if(account.equals(userService.))
        int i = userService.addUser(user);
        if(i==0) return "error";
        return "success";
    }

    @RequestMapping("UserName")
    @ResponseBody
    public List<Map<String,Object>> UserName(HttpServletRequest request){
        if((int)request.getSession().getAttribute("role")!=1){
            return userService.queryUserName((String) request.getSession().getAttribute("account"));
        }
        return userService.queryUserName(null);
    }


}
