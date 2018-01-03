package com.qing.core.exception;

/**
 * @description Ajax异步请求是产生的异常
 *
 * @author 谢进伟
 *
 * @createDate 2016-1-31 下午3:15:18
 */
public class AjaxResponseException extends Exception {

    private static final long serialVersionUID = -6468731617015763009L;

    public AjaxResponseException (String message ){
        super(message);
    }
}
