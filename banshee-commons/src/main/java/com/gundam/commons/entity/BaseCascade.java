package com.gundam.commons.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author kampf
 * @date 2020/4/8 下午3:30
 */
@Data
public class BaseCascade<T> implements Serializable {

    private String value;
    private String parentId;
    private List<T> children;

}
