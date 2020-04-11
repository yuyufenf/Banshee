package com.gundam.gateway.mapper;

import com.gundam.gateway.entity.Operation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author kampf
 * @date 2020/4/11 上午10:15
 */
@Mapper
public interface OperationMapper {

    /**
     *
     * @param operation 对象
     */
    void addOperationLog(Operation operation);
}