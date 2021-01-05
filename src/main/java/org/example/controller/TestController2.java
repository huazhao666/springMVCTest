package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2020-12-26
 * Time : 10:41
 */
@Controller
public class TestController2 {
    @RequestMapping("/test1")
    public String test1(){
        //转发。一次请求，url不变，服务器把资源作为响应体直接返回；
        return "forward:/home.html";
    }
    @RequestMapping("/test2")
    public String test2(){
        //重定向 ,两次请求，url会变，响应3XX+location,浏览器自动跳转
        return "redirect:/home.html";
    }
}
