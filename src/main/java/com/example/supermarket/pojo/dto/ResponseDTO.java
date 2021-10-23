package com.example.supermarket.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    /**
     * 服务端返回给客户端的消息
     */
    private String msg;
    /**
     * 返回的结果
     */
    private Boolean res;
    /**
     * 返回的数据
     */
    private Object data;
    /**
     * 返回的状态
     */
    private Integer status;
    /**
     * 错误代码
     */
    private Integer errorCode;

    /**
     * 返回成功
     * @param msg
     * @return
     */
    public static ResponseDTO ok(String msg){
        return new ResponseDTO(msg,true,null,200,null);
    }

    /**
     * 返回成功
     * 返回的data数据
     * @param msg
     * @return
     */
    public static ResponseDTO ok(String msg,Object data){
        return new ResponseDTO(msg,true,data,200,null);
    }

    /**
     * 返回失败
     * 返回的data数据
     * @param msg
     * @return
     */
    public static ResponseDTO fail(String msg){
        return new ResponseDTO(msg,false,null,null,null);
    }

    /**
     * 返回失败
     * 返回的data数据
     * @param msg
     * @return
     */
    public static ResponseDTO fail(String msg,Object data,Integer status,Integer errorCode){
        return new ResponseDTO(msg,false,data,status,errorCode);
    }


}
