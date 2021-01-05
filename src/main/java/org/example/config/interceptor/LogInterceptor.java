package org.example.config.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.JSONResponse;
import org.example.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2021-01-02
 * Time : 11:28
 */
public class LogInterceptor implements HandlerInterceptor {
    private  ObjectMapper objectMapper;
    public LogInterceptor(ObjectMapper objectMapper) { //构造方法
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if(session != null){ //获取登陆时设置的用户登录信息;
            User user = (User) session.getAttribute("user");
            if(user != null) { //登录，允许访问
                return true;
            }
        }
        //登陆失败，不允许访问的业务;
        //前端跳转，后端返回json
        String path = request.getServletPath();//请求得服务路径
        if(path.startsWith("/api/")){ //后端
            response.setContentType(MediaType.APPLICATION_JSON_VALUE); // 等同于application/json；
            response.setCharacterEncoding("UTF-8");
            JSONResponse json = new JSONResponse();
            json.setCode("USR000");
            json.setMessage("用户没有登录，不允许访问");
            String s = objectMapper.writeValueAsString(json);
            response.setStatus(HttpStatus.UNAUTHORIZED.value());//可以返回401.这里是个枚举类
            PrintWriter writer = response.getWriter();
            writer.println(s);
            writer.flush();
        }else { //前端逻辑；跳转到登录页面，转发；
            //相对路径的写法，一定是请求路径作为相对位置的参照点；
            //使用绝对路径来重定向，不建议使用后相对路径转发；
            String schema = request.getScheme();//获取协议 http;
            String host = request.getServerName();//主机ip
            int port = request.getServerPort();//主机端口号;
            String contextPath = request.getContextPath();//应用上下文路径;
            String basePath = schema + "://" + host + ":" + port + contextPath;
            //重定向
            response.sendRedirect( basePath+ "/view/index.html");
        }
        return false;
    }
}
