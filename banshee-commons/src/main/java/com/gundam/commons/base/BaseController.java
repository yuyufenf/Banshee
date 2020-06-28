package com.gundam.commons.base;


import com.gundam.commons.entity.RespCode;
import com.gundam.commons.entity.RespResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * controller集成熔断器
 * @author kampf
 * @date 2020/4/8 下午3:30
 */
public class BaseController {

    public RespResult globalHystrix(HttpServletRequest request, HttpServletResponse response){
        return RespResult.error(response, RespCode.CODE_HYSTRIX, "");
    }

}
