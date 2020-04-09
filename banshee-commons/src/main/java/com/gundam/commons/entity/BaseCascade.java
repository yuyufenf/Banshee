package com.gundam.commons.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 封装级联对象
 * @author kampf
 * @date 2020/4/8 下午3:30
 */
@Data
@ApiModel(description = "级联查询对象")
public class BaseCascade<T> implements Serializable {

    private static final long serialVersionUID = 7278400460159601789L;

    @ApiModelProperty(value = "对象数据实际内容值", position = 1)
    private String value;
    @ApiModelProperty(value = "对象数据页面展示内容", position = 2)
    private String label;
    @ApiModelProperty(value = "对象数据父级id", position = 3)
    private String parentId;
    @ApiModelProperty(value = "对象数据子类对象集合", position = 4)
    private List<T> children;

}
