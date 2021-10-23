package com.example.supermarket.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BaseUtil {

    protected HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    protected HttpSession getSession(){
        return getRequest().getSession();
    }

    protected Integer getUserId(){
        return (Integer) getSession().getAttribute("userid");
    }

}
