package com.jiuxiao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Mvc自定义配置类
 *
 * @author: WuDaoJiuXiao
 * @Date: 2022/05/21 19:07
 * @since: 1.0.0
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //自定义视图控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    //自定义的国际化组件放到 bean 里才会生效
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    //拦截器配置
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/index.html",
                        "/",
                        "/user/login",
                        "/css/*",
                        "/js/*",
                        "/img/*");
    }
}