package com.jizhang.activiti.exception;

import lombok.Data;

/**
 * 返回体
 */
@Data
public class ResultBody<T> {
    /**
     * 响应代码
     */
    private int code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应结果
     */

    private T data;

    public ResultBody(){

    }

    public ResultBody(CExcetion ce) {
        this.code = ce.getResultCode();
        this.message = ce.getMessage();
    }


    public  ResultBody error(int code,String message){
        this.code=code;
        this.message=message;
        return this;

    }

    public ResultBody(T data, CExcetion ce) {
        this.data=data;
        this.code = ce.getResultCode();
        this.message = ce.getMessage();
    }

    public ResultBody(T data) {
        this.code = SuccessEnum.SUCCESS.resultCode;
        this.message = SuccessEnum.SUCCESS.message;
        this.data = data;
    }

    private enum SuccessEnum{
        SUCCESS(0, "成功");

        public Integer resultCode;
        public String message;

        SuccessEnum(Integer resultCode, String message){
            this.message = message;
            this.resultCode = resultCode;
        }
    }
}
