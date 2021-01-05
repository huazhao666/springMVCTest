package org.example.controller;

import org.example.model.JSONResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2020-12-26
 * Time : 10:41
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/1")
    public String test1(){
        //转发。一次请求，url不变，服务器把资源作为响应体直接返回；
        return "forward:/home.html";
    }
    @RequestMapping("/2")
    public String test2(){
        //重定向 ,两次请求，url会变，响应3XX+location,浏览器自动跳转
        return "redirect:/home.html";
    }
    @RequestMapping("/3")
    @ResponseBody
    public String test3(){
        //重定向 ,两次请求，url会变，响应3XX+location,浏览器自动跳转
        return "redirect:/home.html";
    }
    @RequestMapping("/4")
    @ResponseBody
    public Object test4(){
        Map<Integer,String>map = new HashMap<>();
        map.put(1,"辣鸡");
        map.put(2,"真菜");
        map.put(3,"混子");
        return map;
    }
    @RequestMapping("/5")
    @ResponseBody
    public Object test5(){
        Map<String,Object>map = new HashMap<>();
        map.put("success",false);
        map.put("code","LOG001");
        map.put("message","用户不存在");
        map.put("date",null);
        return map;
    }
    @RequestMapping("/5_1")
    @ResponseBody
    public Object test5_1(){
        JSONResponse js = new JSONResponse();
        js.setSuccess(true);
        js.setCode("LOG001");
        js.setMessage("没有登陆");
        js.setData(233);
        return js;
    }
    @RequestMapping("/6")
    @ResponseBody
    public ResponseEntity test6(){
        JSONResponse js = new JSONResponse();
        js.setSuccess(true);
        js.setCode("LOG001");
        js.setMessage("没有登陆");
        js.setData(233);
        return ResponseEntity.status(401).body(js);//可以设置状态码；
    }
    @RequestMapping("/6_1")
    @ResponseBody
    public String test6_1(){
        return null;
    }
    @RequestMapping("/6_2")
    @ResponseBody
    public Object test6_2(){
        return null;
    }


    @RequestMapping(value = "/7",method = RequestMethod.GET) // 只允许get，也可以{}放很多个；
    @ResponseBody
    public Object test7(){
        Map<Integer,String>map = new HashMap<>();
        map.put(1,"辣鸡");
        map.put(2,"真菜");
        map.put(3,"混子");
        return map;
    }
}
