package com.gundam.commons.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author kampf
 * @date 2020/4/8 下午3:30
 */
@Data
@ApiModel(description = "分页查询条件的基础实体类")
public class BaseQueryCondition implements Serializable {

    @ApiModelProperty(value = "页数[从0开始]", position = 1)
    private int page;
    @ApiModelProperty(value = "每页数据量", position = 2)
    private int size;

}
