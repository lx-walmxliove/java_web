package com.example.supermarket.controller.pages.back.market;

import com.example.supermarket.pojo.dto.ResponseDTO;
import com.example.supermarket.pojo.entity.Market;
import com.example.supermarket.service.MarketService;
import com.example.supermarket.util.LoadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @Controller 控制层，就是我们的action层
 *
 * @Service 业务逻辑层，就是我们的service或者manager层
 *
 * @Repository 持久层，就是我们常说的DAO层
 *
 * @Component  （字面意思就是组件），它在你确定不了事哪一个层的时候使用。
 */

@Controller
public class MarketController {

    @Autowired
    private LoadFileUtil loadFileUtil;
    @Autowired
    private MarketService marketService;


    @RequestMapping("/addmarket")
    public String addmarket(Model model){
        model.addAttribute("types",marketService.selectParentTypeById(-1));
        return "pages/back/market/addmarket";
    }

    /**
     * 添加商品
     * @param market
     * @return
     */
    @RequestMapping("/addMarketdata")
    @ResponseBody
    public Map<String,Object> addMarketdata(Market market, @RequestParam("file") MultipartFile pic) throws IOException {
        String filePath = loadFileUtil.filePath(pic);//图片上传路径
        String[] targets = filePath.split("target");
        market.setMarketImg(targets[1]);
        loadFileUtil.testUp(pic);//图片上传
//        return marketService.addMarket(market);
        return null;
    }

    @RequestMapping("/queryMarketDataById/{id}")
    @ResponseBody
    public ResponseDTO queryMarketDataById(@PathVariable int id){
        return marketService.selectMarketById(id);
    }

}
