package com.gundam.commons.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author kampf
 * @date 2020/4/8 下午3:30
 */
@Data
public class UserLoginInfo implements Serializable {

    /** 用户名*/
    private String userName;
    /** 用户ID*/
    private String userId;
    /** 登录token*/
    private String token;
    /** 角色集合*/
    private List<BaseSelect> roleList;
    /** 用户启用状态*/
    private boolean status;
    /** 用户头像地址*/
    private String imageUrl;
    /** 用户权限集合*/
    private Set<String> permissions;

}
