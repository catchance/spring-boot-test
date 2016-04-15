package org.chance.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

/**
 * Created by wqg on 2016/3/15.
 */

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping("/")
    public String defaultHome(Map<String, Object> model) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        return "redirect:/home";
    }

    @RequestMapping("/home")
 //   @Secured("ROLE_ADMIN")
    public String home(Map<String, Object> model) {
//        System.out.println("aaab");
//        System.out.println("bbbb");
        model.put("message","Hello World");
        model.put("title","Hello Home");
        model.put("date",new Date());
        return "home";
    }

    @RequestMapping("/foo")
    public String foo() {
        throw new RuntimeException("Expected exception in controller");
    }

    @RequestMapping("/homef")
    @Secured("ADMIN")
    public String fo() {
        return "home";
    }
}
