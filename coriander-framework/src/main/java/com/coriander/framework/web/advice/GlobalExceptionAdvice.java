package com.coriander.framework.web.advice;

import com.coriander.common.exception.ServiceException;
import com.coriander.common.result.ResultCode;
import com.coriander.common.result.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常捕获处理
 *
 * @author coriander
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    /**
     * 系统异常
     *
     * @param exception the exception
     * @return the result data
     */
    @ExceptionHandler(value = Exception.class)
    public ResultData<ResultCode> handlerCommerceException(Exception exception, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        log.error("Exception 请求方法:'{}',请求地址:'{}',发生系统异常.", method, requestURI, exception);
        return ResultData.fail(ResultCode.UNKNOWN.code(), exception.getMessage());
    }

    /**
     * 拦截未知的运行时异常
     *
     * @param exception the exception
     * @return the result data
     */
    @ExceptionHandler(value = RuntimeException.class)
    public ResultData<ResultCode> handlerResultException(RuntimeException exception, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        log.error("RuntimeException 请求方法:'{}',请求地址:'{}',发生系统异常.", method, requestURI, exception);
        return ResultData.fail(ResultCode.UNKNOWN.code(), exception.getMessage());
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(ServiceException.class)
    public ResultData<ResultCode> handleServiceException(ServiceException exception) {
        log.error("ServiceException error. message:{}", exception.getMessage(), exception);
        return ResultData.fail(exception.getCode(), exception.getMessage());
    }

    /**
     * 请求方式不支持
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultData<ResultCode> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException exception, HttpServletRequest request) {
        log.error("HttpRequestMethodNotSupportedException 请求地址'{}',不支持'{}'请求", request.getRequestURI(), exception.getMethod());
        return ResultData.fail(ResultCode.Client.COMMON_REQUEST_METHOD_INVALID.code(), exception.getMessage());
    }

}
