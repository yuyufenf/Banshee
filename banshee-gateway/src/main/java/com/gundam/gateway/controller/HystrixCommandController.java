package com.gundam.gateway.controller;

import com.gundam.commons.entity.RespCode;
import com.gundam.commons.entity.RespResult;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kampf
 * @date 2020/4/11 下午2:54
 */
public class HystrixCommandController {
    /**
     * 服务器熔断降级
     */
    @RequestMapping("/hystrixTimeOut")
    public RespResult hystrixTimeOut(){
        return new RespResult(RespCode.CODE_HYSTRIX);
    }

}
