package com.gundam.gateway.service;

import com.gundam.commons.base.BaseService;
import com.gundam.gateway.entity.Operation;

/**
 * @author kampf
 * @date 2020/4/11 上午9:09
 */
public interface OperationService{

    /**
     * 添加日志
     * @param operation 日志对象
     */
    void addOperationLog(Operation operation);
}
