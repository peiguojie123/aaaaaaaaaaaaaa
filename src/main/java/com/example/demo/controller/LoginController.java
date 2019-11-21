package com.example.demo.controller;

import com.example.demo.entity.XsXq;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping(value = "/hello" , method = RequestMethod.GET)
    public String sayHello(){
        XsXq xsxq = new XsXq();
        xsxq.setId(1);
        return "hello springBoot";
    }
}
