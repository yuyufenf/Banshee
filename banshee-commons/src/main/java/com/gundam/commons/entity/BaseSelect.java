package com.gundam.commons.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 封装查询条件
 * @author kampf
 * @date 2020/4/8 下午3:30
 */
@Data
public class BaseSelect implements Serializable {

    private static final long serialVersionUID = 4914617819323880126L;

    @ApiModelProperty(value = "传递", position = 1)
    private String value;
    @ApiModelProperty(value = "每页数据量", position = 2)
    private String label;

}
