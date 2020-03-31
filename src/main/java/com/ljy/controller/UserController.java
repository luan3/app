package com.ljy.controller;

import com.ljy.pojo.User;
import com.ljy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.rmi.MarshalledObject;

@Controller
//@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public String login(@RequestParam("name") String name,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session,
                        HttpServletResponse response){

        User user = userService.login(name, password);
        model.addAttribute("user",user);
        session.setAttribute("user",user);


        if(user!=null){
            //创建cookie对象
            Cookie cookie=new Cookie("name",user.getName());
            //将cookie对象写入浏览器
            response.addCookie(cookie);
            //设置超时时间
            cookie.setMaxAge(10);
            return "success";
        }
        return "fail";
    }

    @RequestMapping("toSuccess")
    public String toSuccss(){
        return "success";
    }
}
