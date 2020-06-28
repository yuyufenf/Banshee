package com.gundam.commons.entity;

import com.gundam.commons.utils.enumerate.RespCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * @author kampf
 * @date 2020/4/8 下午3:30
 */
@Data
@ApiModel(description = "响应实体类")
@NoArgsConstructor
public class RespResult implements Serializable {

    private static final long serialVersionUID = -140509914993350120L;

    @ApiModelProperty(value="后台判断成功值", position = 1)
    private boolean flag;
    @ApiModelProperty(value="请求响应状态码", position = 2)
    private int code;
    @ApiModelProperty(value="请求响应消息", position = 3)
    private String msg;
    @ApiModelProperty(value="请求响应内容", position = 4)
    private Object data;

    private RespResult(RespCode respCode, Object data, Object... msg){
        this.flag = respCode.isFlag();
        this.code = respCode.getCode();
        this.msg = String.format(respCode.getMsg(), msg);
        this.data = data;
    }

    public static RespResult success(HttpServletResponse response, Object data, String msg){
        response.setStatus(200);
        return new RespResult(RespCode.SUCCESS, data, msg);
    }

    public static RespResult error(HttpServletResponse response, RespCode respCode, String msg){
        response.setStatus(respCode.getCode());
        return new RespResult(respCode, null, msg);
    }

    public static RespResult error(HttpServletResponse response, RespCode respCode, Object data, String msg){
        response.setStatus(respCode.getCode());
        return new RespResult(respCode, data, msg);
    }
}
