package org.example.DaoController;

import org.example.model.JSONResponse;
import org.example.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2021-01-02
 * Time : 9:22
 */
@RestController 
@RequestMapping("/user")
public class UserController {
    @PostMapping("/login")
    public Object login(User user, HttpServletRequest req){
        JSONResponse json = new JSONResponse();
        if("abc".equals(user.getUsername())){
            //通过请求头Cookie;JSESSIONID=xxx；服务端Map中查找通过xxx寻找session
            //找到session就返回，找不到就创建；
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            json.setSuccess(true);
        }else {
            json.setCode("USERLOG001");
            json.setMessage("用户名或密码错误");
        }
        return json;
    }
}
