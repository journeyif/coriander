package com.coriander.common.exception;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.coriander.common.result.ResultCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 业务异常
 *
 * @author coriander
 */
@Getter
@Setter
public final class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误提示
     */
    private String message;

    public ServiceException(String message) {
        this.code = ResultCode.UNKNOWN.code();
        this.message = message;
    }

    public ServiceException(ResultCode.Business resultCode, Object... args) {
        this.code = resultCode.code();
        if (ArrayUtil.isNotEmpty(args)) {
            this.message = StrUtil.format(resultCode.message(), args);
        } else {
            this.message = resultCode.message();
        }
    }

    public ServiceException() {
        this.code = ResultCode.UNKNOWN.code();
        this.message = ResultCode.UNKNOWN.message();
    }

    public ServiceException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}