package org.chance.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * Created by wqg on 2016/3/22.
 */

@Controller
public class WelcomeController {

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @RequestMapping("/jsp/welcome")
    public String welcome(Map<String, Object> model) {
        model.put("time",new Date());
        model.put("message", this.message);
        return "welcome";
    }

    @RequestMapping("/jsp/foo")
    public String foo(Map<String, Object> model) {
        throw new RuntimeException("Foo");
    }

}
