package com.coriander.common.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 返回值封装
 *
 * @author coriander
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultData<T> implements Serializable {

    private static final long serialVersionUID = -7147339207015646972L;
    /**
     * 返回状态码
     */
    private int code;

    /**
     * 返回结果描述
     */
    private String message;

    /**
     * 返回参数
     */
    private T data;

    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 返回时间
     */
    private long timestamp;


    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }


    public static <T> ResultData<T> success(String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ResultCode.SUCCESS.code());
        resultData.setMessage(message);
        resultData.setSuccess(Boolean.TRUE);
        return resultData;
    }

    public static <T> ResultData<T> success() {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ResultCode.SUCCESS.code());
        resultData.setMessage(ResultCode.SUCCESS.message());
        resultData.setSuccess(Boolean.TRUE);
        return resultData;
    }

    public static <T> ResultData<T> success(T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ResultCode.SUCCESS.code());
        resultData.setMessage(ResultCode.SUCCESS.message());
        resultData.setData(data);
        resultData.setSuccess(Boolean.TRUE);
        return resultData;
    }

    public static <T> ResultData<T> fail(String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ResultCode.FAIL.code());
        resultData.setMessage(message);
        resultData.setSuccess(Boolean.FALSE);
        return resultData;
    }

    public static <T> ResultData<T> fail(int code, String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(code);
        resultData.setMessage(message);
        resultData.setSuccess(Boolean.FALSE);
        return resultData;
    }

    public static <T> ResultData<T> fail() {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ResultCode.FAIL.code());
        resultData.setMessage(ResultCode.FAIL.message());
        resultData.setSuccess(Boolean.FALSE);
        return resultData;
    }

}