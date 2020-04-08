package com.gundam.commons.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author kampf
 * @date 2020/4/8 下午3:30
 */
@Data
public class Cascade implements Serializable {

    private String value;
    private String label;
    private String pId;
    private List<Cascade> children = null;

}
