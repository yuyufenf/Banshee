package com.gundam.commons.base;

import com.gundam.commons.utils.OrderIdUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 创建公用复用对象属性
 * @author kampf
 * @date 2020/4/8 下午3:41
 */
@Data
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 2383962095358069350L;

    private OrderIdUtil idUtil = new OrderIdUtil(1, 1);

    @ApiModelProperty(value = "字段ID(\"后端自动生成\")", required = true)
    protected Long id;

    @ApiModelProperty(value = "创建时间(\"后端自动生成\")")
    protected Date createDate;

    @ApiModelProperty(value = "字段创建者(\"前段从登录用户缓存中获取\")")
    protected String createName;

    @ApiModelProperty(value = "字段删除状态(\"后端生成默认值\")", required = true)
    protected int deal;

    @ApiModelProperty(value = "字段备注以及替换")
    protected String remark;

    protected BaseEntity(){
        this.id = idUtil.nextId();
        this.createDate = new Date(System.currentTimeMillis());
        this.deal = 0;
    }

    /**
     * 添加一个打印json字符串的方法
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("id:").append(id);
        sb.append(", createDate:").append(createDate);
        sb.append(", createName:").append(createName);
        sb.append(", deal:").append(deal);
        sb.append(", remark:").append(remark);
        return  sb.toString();
    }
}
