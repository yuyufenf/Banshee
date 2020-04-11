package com.gundam.gateway.service.serviceImpl;

import com.gundam.commons.base.BaseServiceImpl;
import com.gundam.commons.entity.RespResult;
import com.gundam.gateway.entity.Operation;
import com.gundam.gateway.mapper.OperationMapper;
import com.gundam.gateway.service.OperationService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author kampf
 * @date 2020/4/11 上午10:21
 */
@Slf4j
@Service
public class OperationServiceImpl implements OperationService {

    @Resource
    OperationMapper operationMapper;

    @Async("gatewayLogAsync")
    @HystrixCommand(fallbackMethod = "addOperationLog", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @Override
    public void addOperationLog(Operation operation) {
        operation.setVisitorTime(operation.getCreateDate());
        log.info("异步执行日志存入");
        operationMapper.addOperationLog(operation);
    }
}
