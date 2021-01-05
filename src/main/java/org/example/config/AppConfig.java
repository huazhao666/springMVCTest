package org.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.config.interceptor.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2021-01-01
 * Time : 12:05
 */
//定义springMVC得启动配置类；
@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //设置路径前缀得规则，
        configurer.addPathPrefix("api",c->true);
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //前端处理逻辑和后端是否一样？----不一样；
        //前端敏感资源在拦截器中，处理为没登录跳转到首页；
        //后端敏感资源在拦截器中处理为：返回json，401状态码；
        registry.addInterceptor(new LogInterceptor(objectMapper))
                //*代表路径得下一级，**代表所有子集；
                //所有非/api/user
                //后端；
                .addPathPatterns("/api/**")
                //排除后端，后端为开放资源;
                .excludePathPatterns("/api/user/**")
                .addPathPatterns("/view/article.html")
                .addPathPatterns("/view/main.html");

    }
}
