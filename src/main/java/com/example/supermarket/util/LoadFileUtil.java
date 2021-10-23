package com.example.supermarket.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
public class LoadFileUtil {

    MultipartFile photo = null;
    String filename = "";

    public void init(MultipartFile photo){
        this.photo = photo;
        filename = photo.getOriginalFilename();
    }

    //上传路径
    public String filePath(MultipartFile photo) {
        init(photo);
        //解决上传文件重名会把前一个文件覆盖的问题
        //提取文件后缀名
        String suffixName = filename.substring(filename.lastIndexOf("."));
        //将UUID作为文件名
        String uuid = UUID.randomUUID().toString().replaceAll("-","");//把uuid生成的横线换成空字符串
        //将uuid和后缀名拼接后的结果作为最终的文件名
        filename = uuid + suffixName;
//        ServletContext servletContext = session.getServletContext();//获取服务器中的photo问题
//        String photopath = servletContext.getRealPath("photo");//上传的位置
        String photopath = "D:\\Myproject\\supermarket\\target\\photo";//上传的位置
        File file = new File(photopath);
        //判断目录存不存在
        if(!file.exists()){
            //不存在则创建
            file.mkdir();
        }
        //最终的路径
        String finalPath = photopath + File.separator + filename;
        return finalPath;
    }

    //上传文件
    public void testUp(MultipartFile photo) throws IOException {
        String finalPath = filePath(photo);
        photo.transferTo(new File(finalPath));//上传
    }

}
