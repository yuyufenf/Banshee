package com.gundam.commons.base;

import com.gundam.commons.entity.BaseCascade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 创建公用mapper接口
 * @author kampf
 * @date 2020/4/8 下午3:30
 */
public interface BaseMapper<T, Query> {

    /**
     * 通用信息新增
     * @param t 删除信息
     * @return 新增是否成功
     */
    int insert(T t);

    /**
     * 通用信息修改
     * @param t 参数信息
     * @return 修改是否成功
     */
    int modify(T t);

    /**
     * 查询当前id下是否存在子级
     * @param id 查询条件
     * @return 是否有子级
     */
    int queryChild(String id);

    /**
     * 通用删除
     * @param id 删除条件
     * @return 是否删除成功
     */
    int delete(long id);

    /**
     * 分页条件总数查询
     * @param queryCondition 条件参数对象
     * @return 条件查询总数
     */
    int queryTotal(@Param("queryCondition") Query queryCondition);

    /**
     * 分页条件查询
     * @param queryCondition 条件参数对象
     * @return 条件查询结果集
     */
    List<T> query(@Param("queryCondition") Query queryCondition);

}
