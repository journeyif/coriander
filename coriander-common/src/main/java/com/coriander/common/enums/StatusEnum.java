package com.coriander.common.enums;

import lombok.Getter;

/**
 * @author coriander
 */
@Getter
public enum StatusEnum {

    ENABLE("0", "正常"),

    DISABLE("1", "停用"),

    DELETE("2", "删除");

    private final String code;
    private final String value;

    StatusEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }
}
