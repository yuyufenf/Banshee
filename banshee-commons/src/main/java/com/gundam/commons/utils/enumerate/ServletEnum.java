package com.gundam.commons.utils.enumerate;

/**
 * 各服务用枚举值
 * @author kampf
 * @date 2020/6/28 下午3:34
 * @description
 */
public enum ServletEnum {

    /***/
    COMMONS_SERVLET(1),
    FILES_SERVLET(2),
    GATEWAY_SERVLET(3),
    USER_SERVLET(4),
    ;

    private int servletId;

    public int getServletId() {
        return servletId;
    }

    public void setServletId(int servletId) {
        this.servletId = servletId;
    }

    ServletEnum(int servletId){
        this.servletId = servletId;
    }


}
