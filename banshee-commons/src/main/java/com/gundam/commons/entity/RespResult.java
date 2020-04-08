package com.gundam.commons.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @author kampf
 * @date 2020/4/8 下午3:30
 */
@Data
@ApiModel(description = "响应实体类")
@NoArgsConstructor
public class RespResult implements Serializable {

    @ApiModelProperty(value="请求是否成功", position = 1)
    private boolean flag;
    @ApiModelProperty(value="请求响应状态码", position = 2)
    private int code;
    @ApiModelProperty(value="请求响应消息", position = 3)
    private String msg;
    @ApiModelProperty(value="请求响应内容", position = 4)
    private Object data;

    public RespResult(RespCode respCode){
        this.flag = respCode.isFlag();
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
    }

    public RespResult(RespCode respCode, Object data){
        this.flag = respCode.isFlag();
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
        this.data = data;
    }

    public RespResult(RespCode respCode, String msg){
        this.flag = respCode.isFlag();
        this.code = respCode.getCode();
        this.msg = msg;
    }

    public RespResult(RespCode respCode, String msg, Object data){
        this.flag = respCode.isFlag();
        this.code = respCode.getCode();
        this.msg = msg;
        this.data = data;
    }

    public RespResult(boolean flag, int code, String msg, Object data) {
        this.flag = flag;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
