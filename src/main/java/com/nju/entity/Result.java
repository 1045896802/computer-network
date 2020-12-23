package com.nju.entity;

import com.nju.exception.BusinessMsgEnum;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author Maxyu
 * @date 2020/12/17 14:18
 */
@Getter
@Setter
@AllArgsConstructor
@Accessors(chain = true)
public class Result<T> {
    private T data;
    private String code;
    private Boolean success;
    private String msg;

    /**
     * 若没有数据返回，默认状态码为0，提示信息为:操作成功!
     */
    public Result() {
        this.code = "0";
        this.success = true;
        this.msg = "操作成功! ";
    }

    /**
     * 若没有数据返回，可以人为指定状态码和提示信息
     *
     * @param code
     * @param msg
     */
    public Result(String code, Boolean success, String msg) {
        this.code = code;
        this.success = success;
        this.msg = msg;
    }

    /**
     * 有数据返回时，状态码为0，默认提示信息为:操作成功!
     *
     * @param data
     */
    public Result(T data) {
        this.data = data;
        this.code = "0";
        this.success = true;
        this.msg = "操作成功! ";
    }

    /**
     * 有数据返回，状态码为0，人为指定提示信息
     *
     * @param data
     * @param success
     * @param msg
     */
    public Result(T data, Boolean success, String msg) {
        this.data = data;
        this.code = "0";
        this.success = success;
        this.msg = msg;
    }


    /**
     * 有数据返回，状态码为0，人为指定提示信息
     *
     * @param data
     * @param success
     */
    public Result(T data, Boolean success) {
        this.data = data;
        this.code = "0";
        this.success = success;
    }

    /**
     * 使用自定义异常作为参数传递状态码和提示信息
     *
     * @param msgEnum
     */
    public Result(BusinessMsgEnum msgEnum) {
        this.code = msgEnum.code();
        this.msg = msgEnum.msg();
    }
}



