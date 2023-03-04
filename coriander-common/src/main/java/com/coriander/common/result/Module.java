package com.coriander.common.result;

/**
 * 系统内的模块
 *
 * @author coriander
 */
public enum Module {

    /**
     * 通用
     */
    COMMON(0),

    /**
     * 用户
     */
    USER(1),

    /**
     * 部门
     */
    DEPT(2),

    /**
     * 角色
     */
    ROLE(3),

    /**
     * 权限
     */
    PERMISSION(4),

    /**
     * 菜单
     */
    MENU(5),

    /**
     * 登录
     */
    LOGIN(6);


    private final int code;

    Module(int code) {
        this.code = code * 100;
    }

    public int code() {
        return code;
    }

}
