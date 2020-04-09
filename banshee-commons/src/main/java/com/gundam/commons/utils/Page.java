package com.gundam.commons.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 封装级联对象
 * @author kampf
 * @date 2020/4/9 下午3:41
 */
@Data
public class Page implements Serializable {

    private static final long serialVersionUID = 1735874124467450625L;

    /**
     * 分页总数
     */
    private int total;

    /**
     *
     */
    private Object data;

}
