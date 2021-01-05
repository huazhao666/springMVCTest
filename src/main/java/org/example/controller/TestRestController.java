package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2020-12-26
 * Time : 12:04
 */
@RestController
@RequestMapping("/test")
public class TestRestController {
    @GetMapping("/1")
    public Object test1(){
        Map<String,Object> map = new HashMap<>();
        map.put("success",false);
        map.put("code","LOG001");
        map.put("message","用户不存在");
        map.put("date",null);
        return map;
    }
}
