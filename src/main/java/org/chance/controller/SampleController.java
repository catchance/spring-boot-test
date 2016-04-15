package org.chance.controller;

import org.chance.service.CityService;
import org.chance.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wqg on 2016/3/12.
 */

@Controller
@RequestMapping("")
public class SampleController {
    @Autowired
    private HelloWorldService helloWorldService;

    @Autowired
    private CityService cityService;

    @RequestMapping("/hello")
    @ResponseBody
    public String helloWorld(){
        return this.helloWorldService.getHelloMessage();
    }

    @RequestMapping("/jpa")
    @ResponseBody
    @Transactional(readOnly = true)
    public String jpa(){
        return this.cityService.getCity("Bath", "UK").getName();
    }
}
