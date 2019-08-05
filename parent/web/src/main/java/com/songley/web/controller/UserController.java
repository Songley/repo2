package com.songley.web.controller;




import com.songley.entity.User;
import com.songley.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/hello")
    public String index(){
        return "login";
    }
    @RequestMapping("login.action")
    public ModelAndView login(User user,HttpServletRequest request,HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user.setUsername(username);
        user.setPassword(password);
        user = this.userService.dologin(user);
        if (user!=null){
            session.setAttribute("user",user);
            modelAndView.setViewName("detail");
            return modelAndView;
        }else {
            session.setAttribute("errormsg","账号或密码错误");
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
