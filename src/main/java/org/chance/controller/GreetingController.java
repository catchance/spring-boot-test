package org.chance.controller;

import org.chance.entity.sys.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wqg on 2016/3/18.
 */

@Controller
@RequestMapping("/s")
public class GreetingController {

    @RequestMapping("/home")
    public String home(){
        return "redirect:/home";
    }

    @RequestMapping("/hello")
    public String hello() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        if(auth.getPrincipal() instanceof UserDetails ){
            SysUser user = (SysUser) auth.getPrincipal();
            System.out.println(user.getName());
        }

        return "hello";
    }

    @RequestMapping("/")
    public String root() {
        return "redirect:/home";
    }

//    @RequestMapping("/login")
//    public String login(){
//        return "login";
//    }

}
