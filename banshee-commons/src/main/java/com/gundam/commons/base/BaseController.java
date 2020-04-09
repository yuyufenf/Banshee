package com.gundam.commons.base;


import com.gundam.commons.entity.RespCode;
import com.gundam.commons.entity.RespResult;

/**
 * controller集成熔断器
 * @author kampf
 * @date 2020/4/8 下午3:30
 */
public class BaseController {

    public RespResult globalHystrix(){
        return new RespResult(RespCode.CODE_HYSTRIX);
    }

}
