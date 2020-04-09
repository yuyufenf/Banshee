package com.gundam.commons.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 封装查询分页方法
 * @author kampf
 * @date 2020/4/8 下午3:30
 */
@Data
@ApiModel(description = "分页查询条件的基础实体类")
public class BaseQueryCondition implements Serializable {

    private static final long serialVersionUID = -5105565702706699319L;

    @ApiModelProperty(value = "页数[从0开始]", position = 1)
    private int page;
    @ApiModelProperty(value = "每页数据量", position = 2)
    private int size;

}
