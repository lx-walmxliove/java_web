package com.example.supermarket.controller.pages.front;

import com.example.supermarket.dao.ShopCarDao;
import com.example.supermarket.pojo.dto.ResponseDTO;
import com.example.supermarket.service.ShopCarService;
import com.example.supermarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/page/front")
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    ShopCarService shopCarService;

    @RequestMapping("/loginPage")
    public String loginPage(String url,Model model){
        System.out.println(url);
        model.addAttribute("url",url);
        return "pages/front/login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public ResponseDTO login(String username, String password,HttpSession session){
        if("".equals(username) || username == null){
            return ResponseDTO.fail("请输入用户名或者手机号！！");
        }else if("".equals(password) || password == null){
            return ResponseDTO.fail("请输入密码！！");
        }
        if(userService.login(username,password) == null){
            return ResponseDTO.fail("用户名或密码错误！！");
        }
        session.setAttribute("userid",userService.login(username,password).getUserId());
        session.setAttribute("shopcarcount",shopCarService.countshopcar(userService.login(username,password).getUserId()));
        return ResponseDTO.ok("登录成功!!!");
    }
}
