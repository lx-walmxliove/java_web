package com.example.supermarket.controller.pages.back.market;

import com.example.supermarket.pojo.dto.ResponseDTO;
import com.example.supermarket.pojo.entity.Market;
import com.example.supermarket.pojo.entity.ShopCar;
import com.example.supermarket.service.ShopCarService;
import com.example.supermarket.service.UserService;
import com.example.supermarket.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ShopCarController extends BaseUtil {
    @Autowired
    ShopCarService shopCarService;

    @RequestMapping("/addShopcar")
    @ResponseBody
    public ResponseDTO addShopcar(ShopCar shopCar, HttpSession session){
        Integer userid = (Integer) session.getAttribute("userid");
        if(StringUtils.isEmpty(userid)){
            return ResponseDTO.fail("操作失败，请先登录！",null,401,401);
        }
        shopCar.setUserId(userid);
        return shopCarService.edit(shopCar);
    }

    @RequestMapping("/showshopcar")
    public String showshopcar(Model model){
        if(!StringUtils.isEmpty(getUserId())){
            List<ShopCar> shopCars = shopCarService.AllQueryShopCar();
            model.addAttribute("cars",shopCars);
        }else{
            return "/pages/front/login";
        }
        return "/pages/front/showshopcar";
    }
}
