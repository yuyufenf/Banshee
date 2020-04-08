package com.gundam.commons.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author kampf
 * @date 2020/4/8 下午3:30
 */
@Data
public class BaseSelect implements Serializable {

    private String value;
    private String label;

}
