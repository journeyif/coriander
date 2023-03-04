package com.coriander.common.result;

import java.util.stream.Stream;

/**
 * 返回值枚举
 *
 * @author coriander
 */

public enum ResultCode implements ResultCodeInterface {

    /*
      错误码集合
      -200~9999 为保留错误码 或者 常用错误码
      10000~19999 为内部错误码
      20000~29999 客户端错误码 （客户端异常调用之类的错误）
      30000~39999 为第三方错误码 （代码正常，但是第三方异常）
      40000~49999 为业务逻辑 错误码 （无异常，代码正常流转，并返回提示给用户）
     */

    /**
     * 操作成功
     **/
    SUCCESS(200, "操作成功"),

    /**
     * 操作失败
     */
    FAIL(-200, "操作失败"),

    /**
     * 服务异常
     **/
    UNKNOWN(-1, "正体不明");


    /**
     * 自定义状态码
     **/
    private final int code;
    /**
     * 自定义描述
     **/
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }


    /**
     * 根据 code 获取枚举
     */
    public static ResultCode of(int code) {
        return Stream.of(values())
                .filter(bean -> bean.code == code)
                .findAny()
                .orElseThrow(
                        () -> new IllegalArgumentException(code + " not exists")
                );
    }

    @Override
    public int code() {
        return this.code;
    }

    @Override
    public String message() {
        return this.message;
    }


    /**
     * 40000~49999 为业务逻辑 错误码 （无代码异常，代码正常流转，并返回提示给用户）
     */
    public enum Business implements ResultCodeInterface {

        // ----------------------------- Common --------------------------------------

        OBJECT_NOT_FOUND(Module.COMMON, 1, "找不到ID为 {} 的 {}"),
        UNSUPPORTED_OPERATION_ADMIN(Module.COMMON, 2, "不允许操作超级管理员角色"),

        // ---------------------------------- User -----------------------------------------------
        USERNAME_PASSWORD_REQUIRED(Module.USER, 1, "账号/密码必填"),
        PASSWORD_ILLEGALITY(Module.USER, 2, "密码非法"),
        USERNAME_ILLEGALITY(Module.USER, 3, "账号非法"),
        USER_NON_EXIST(Module.USER, 4, "登录用户：{} 不存在"),
        USERNAME_DELETE(Module.USER, 5, "对不起， 领的账号：{} 已被删除"),
        USERNAME_DISABLE(Module.USER, 6, "对不起， 您的账号：{} 已停用"),

        // ------------------------------- Dept ---------------------------------------------
        DEPT_NAME_IS_NOT_UNIQUE(Module.DEPT, 1, "部门名称:{}, 已存在"),
        DEPT_PARENT_DEPT_NO_EXIST_OR_DISABLED(Module.DEPT, 2, "该父级部门不存在或已停用"),
        DEPT_PARENT_ID_IS_NOT_ALLOWED_SELF(Module.DEPT, 3, "父级部门不能选择自己"),
        DEPT_STATUS_ID_IS_NOT_ALLOWED_CHANGE(Module.DEPT, 4, "子部门还有正在启用的部门，暂时不能停用该部门"),
        DEPT_EXIST_CHILD_DEPT_NOT_ALLOW_DELETE(Module.DEPT, 5, "该部门存在下级部门不允许删除"),
        DEPT_EXIST_LINK_USER_NOT_ALLOW_DELETE(Module.DEPT, 6, "该部门存在关联的用户不允许删除"),


        // -------------------------------- Role -------------------------------------------------
        ROLE_NAME_IS_NOT_UNIQUE(Module.ROLE, 1, "角色名称：{}, 已存在"),
        ROLE_KEY_IS_NOT_UNIQUE(Module.ROLE, 2, "角色标识：{}, 已存在"),

        ROLE_DATA_SCOPE_DUPLICATED_DEPT(Module.ROLE, 3, "重复的部门id"),
        ROLE_ALREADY_ASSIGN_TO_USER(Module.ROLE, 4, "角色已分配给用户，请先取消分配，再删除角色"),
        ROLE_IS_NOT_AVAILABLE(Module.ROLE, 5, "角色：{} 已禁用，无法分配给用户"),

        // ----------------------------- Permission -----------------------------------

        FORBIDDEN_TO_MODIFY_ADMIN(Module.PERMISSION, 1, "不允许修改管理员的信息"),
        NO_PERMISSION_TO_OPERATE(Module.PERMISSION, 2, "没有权限进行此操作，请联系管理员"),

        // -------------------------------  Menu -------------------------------------------------

        MENU_NAME_IS_NOT_UNIQUE(Module.MENU, 1, "新增菜单:{} 失败，菜单名称已存在"),
        MENU_EXTERNAL_LINK_MUST_BE_HTTP(Module.MENU, 2, "菜单外链必须以 http(s)://开头"),
        MENU_PARENT_ID_NOT_ALLOW_SELF(Module.MENU, 3, "父级菜单不能选择自身"),
        MENU_EXIST_CHILD_MENU_NOT_ALLOW_DELETE(Module.MENU, 4, "存在子菜单不允许删除"),
        MENU_ALREADY_ASSIGN_TO_ROLE_NOT_ALLOW_DELETE(Module.MENU, 5, "菜单已分配给角色，不允许"),

        // ----------------------------- Login -----------------------------------------

        LOGIN_WRONG_USER_PASSWORD(Module.LOGIN, 1, "用户密码错误，请重输"),
        LOGIN_ERROR(Module.LOGIN, 2, "登录失败：{}"),
        LOGIN_CAPTCHA_CODE_WRONG(Module.LOGIN, 3, "验证码错误"),
        LOGIN_CAPTCHA_CODE_EXPIRE(Module.LOGIN, 4, "验证码过期"),
        LOGIN_CAPTCHA_CODE_NULL(Module.LOGIN, 5, "验证码为空");


        private final int code;
        private final String message;

        private static final int BASE_CODE = 40000;

        Business(Module module, int code, String message) {
            this.code = BASE_CODE + module.code() + code;
            this.message = message;
        }

        @Override
        public int code() {
            return this.code;
        }

        @Override
        public String message() {
            return this.message;
        }
    }

    /**
     * 20000~29999是客户端错误码
     */
    public enum Client implements ResultCodeInterface {
        COMMON_FORBIDDEN_TO_CALL(Module.COMMON, 1, "禁止调用"),
        COMMON_REQUEST_TO_OFTEN(Module.COMMON, 2, "调用太过频繁"),
        COMMON_REQUEST_PARAMETERS_INVALID(Module.COMMON, 3, "请求参数异常，{}"),
        COMMON_REQUEST_METHOD_INVALID(Module.COMMON, 4, "请求方式: {} 不支持"),
        ;

        private final int code;
        private final String msg;

        private static final int BASE_CODE = 20000;

        Client(Module module, int code, String msg) {
            this.code = BASE_CODE + module.code() + code;
            this.msg = msg;
        }

        @Override
        public int code() {
            return this.code;
        }

        @Override
        public String message() {
            return this.msg;
        }

    }
}