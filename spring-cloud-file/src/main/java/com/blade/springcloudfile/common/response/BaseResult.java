package com.blade.springcloudfile.common.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * 通过返回值类
 *
 * @author lyq
 * @create 6/15/19
 */
@Data
public class BaseResult {

    /**
     * 状态码
     */
    private int code;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 返回信息
     */
    private String message;

    public BaseResult() {
    }

    public BaseResult(Object data) {
        this.data = data;
    }

    public BaseResult(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public BaseResult(int code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseResult success() {
        this.code = HttpStatus.OK.value();
        this.data = true;
        this.message = "请求成功";
        return this;
    }

    public BaseResult success(Object data) {
        this.code = HttpStatus.OK.value();
        this.data = data;
        this.message = "请求成功";
        return this;
    }

    public BaseResult error() {
        this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.data = false;
        this.message = "请求失败";
        return this;
    }

    public BaseResult error(Object data, String message) {
        this.code = 500;
        this.data = data;
        this.message = message;
        return this;
    }
}
