package com.gundam.commons.base;


import com.gundam.commons.entity.RespResult;

/**
 * 创建公用事物接口
 * @author kampf
 * @date 2020/4/8 下午3:30
 */
public interface BaseService<T, Query> {

    /**
     * 通用获取可用的父级级联表
     * @return 级联表
     */
    RespResult queryCascade();

    /**
     * 通用新增接口
     * @param t 新增所需的参数实体类
     * @param message 返回语句说明,输入模块名称即可
     * @return 统一响应数据
     */
    RespResult insert(T t, String message);

    /**
     * 通用删除接口
     * @param id 删除字段id
     * @param message 返回语句说明,输入模块名称即可
     * @return 统一响应数据
     */
    RespResult delete(long id, String message);

    /**
     * 通用修改接口
     * @param t 修改所需的参数实体类
     * @param message 返回语句说明,输入模块名称即可
     * @return 统一响应数据
     */
    RespResult modify(T t, String message);

    /**
     * 通用的分页条件查询
     * @param queryCondition 查询条件实体类
     * @return 统一响应数据
     */
    RespResult query(Query queryCondition);

}
