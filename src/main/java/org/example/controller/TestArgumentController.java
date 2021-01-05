package org.example.controller;

import org.example.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2021-01-01
 * Time : 9:21
 */

/**
 * @RequestParam ： 除了application/json格式，其他的都可以通过key获取value：
 * 必须要有东西提交，除非使用required = false;
 * pojo 对象和使用@RequestParam(required = false)作用一样；不需要使用注解；
 * 使用@RequestBody:接受请求数据为application/json;
 * 使用那种方式获取请求数据 ：
 * 0.pojo比@RequestParam书写起来更加方便；
 * 1.请求数据比较少，一般不使用json，如果没有自定义，可以直接使用包装类型；
 * 2.请求数据比较多，请求数据类型可能是json（@RequestBody）；可能表单默认提交方式，或者form-data；-->POJO
 * 区分请求数据类型为json和非json得
 * 3.@RequestPart:二进制文件，默认是required = true：
 * 4.
 *
 *
 * 注意： 不建议写基本数据类型，全部包装类型；
 * 返回视图 不带@ResponseBody，返回类型为String;
 * 返回json数据 方法带@ResponseBody,类上得也是作用在方法上注解，返回Object
 * 请求数据为json;@RequestBody  如果报错，请求的json数据有某个key，反序列化得java对象中，没有改属性，报错；
 *                            反序列化得java对象中有某个属性，请求的json数据没有key，不报错；java中的属性就是默认值；
 * 请求数据不是json，或者是get请求，使用pojo， 如果发现pojo对象和对象中得属性为null；一定是请求中没有这个key；
 *Servlet :session相关; 登陆操作 用户会话管理；
 *
 *
 * */

@RestController
@RequestMapping("/arg")
public class TestArgumentController {
    private static final Logger logger = LoggerFactory.getLogger(TestArgumentController.class);
    @GetMapping("/holiday/{day}")
    public Object holiday(@PathVariable String day){
        logger.debug("获取路径参数" + day);
        Map<String,Object> map = new HashMap<>();
        map.put("ok",true);
        return map;
    }
    @PostMapping("/login")
    public Object login(@RequestParam String username,@RequestParam String password){
        logger.debug("获取路径参数: username={},password={}", username, password);
        Map<String,Object> map = new HashMap<>();
        map.put("no",true);
        return map;
    }
    @PostMapping("/login2")
    public Object login2(@RequestParam(required = false) Integer i){ //代表i非必填得；这里的必须是包装类型；int 没有默认之，
        logger.debug("获取路径参数: i = "+ i);
        Map<String,Object> map = new HashMap<>();
        map.put("no",true);
        return map;
    }
    @PostMapping("/register")
    public Object login3(@RequestParam String username, @RequestParam String password,
                         @RequestParam MultipartFile file) throws IOException { //除了application/json格式，其他的都可以
        logger.debug("获取路径参数: username={},password={}", username, password);
        logger.debug("头像信息，名称={},内容={}",file.getOriginalFilename(),
                new String(file.getBytes()));
        Map<String,Object> map = new HashMap<>();
        map.put("no",true);
        return map;
    }
    //MVC自动实例化user对象，根据请求key获取值注入到user对象得属性中
    @PostMapping("/login/pojo")
    public Object loginPojo(User user){
      //  logger.debug("获取路径参数: username={},password={}", user.getUsername(), user.getPassword(),user.getI());
        Map<String,Object> map = new HashMap<>();
        map.put("no",true);
        return map;
    }
    @PostMapping("/login/pojo1")
    public Object loginPojo1( String username, String password){
        logger.debug("获取路径参数: username={},password={}", username, password);
        Map<String,Object> map = new HashMap<>();
        map.put("no",true);
        return map;
    }
    @PostMapping("/register/pojo")
    public Object loginPojo(User user, MultipartFile file) throws IOException { //除了application/json格式，其他的都可以
      //  logger.debug("获取路径参数: username={},password={}", user.getUsername(), user.getPassword(),user.getI());
        Map<String,Object> map = new HashMap<>();
        map.put("no",true);
        return map;
    }

    @PostMapping("/json")
    public Object json(@RequestBody User user){
        logger.debug("用户信息为: {}",user);
        Map<String,Object> map = new HashMap<>();
        map.put("no",true);
        return map;
    }
    public Object file(@RequestPart MultipartFile file) throws IOException {
        logger.debug("头像信息，名称={},内容={}",file.getOriginalFilename(),
                new String(file.getBytes()));
        Map<String,Object> map = new HashMap<>();
        map.put("no",true);
        return map;
    }

}
