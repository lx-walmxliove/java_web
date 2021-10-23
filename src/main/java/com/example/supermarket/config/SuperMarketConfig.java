package com.example.supermarket.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.supermarket.util.LoadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SuperMarketConfig implements WebMvcConfigurer {

    @Bean
    public DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setPassword("123456");
        druidDataSource.setUsername("root");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/supermarket?useSSL=false&serverTimezone=GMT%2B8&characterEncoding=utf-8&autoReconnect=true");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setValidationQuery("SELECT 1");
        return druidDataSource;
    }

    //文件上传解析器
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        return new CommonsMultipartResolver();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        /*file: 后面是图片在服务器上的路径*/
        registry.addResourceHandler("/photo/**").addResourceLocations("file:D:/Myproject/supermarket/target/photo/");
    }
}
