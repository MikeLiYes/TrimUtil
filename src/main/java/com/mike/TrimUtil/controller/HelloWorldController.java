package com.mike.TrimUtil.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloWorldController {

    @GetMapping("/detail")
    public String detail(String hello){
        return hello;
    }
    
    @GetMapping("/detail2")
    public String detailObject(Detail hello){
        return hello.getMark() + "----------" + hello.getWeight() + "-----" + hello.getIsWeek();
    }
    
    @GetMapping("/detail3")
    public String detail3(){
        return "detail3";
    }
}    