package com.jizhang.activiti.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CExcetion extends Exception{

    /**
     * 错误码
     */
    private Integer resultCode;

    /**
     * 错误描述
     */
    private String message;

    public CExcetion(String message){
        super(message);
        this.message = message;
    }

    public CExcetion(Integer code, String message){
        this.resultCode = code;
        this.message = message;
    }

    public CExcetion(String message, Throwable e){
        super(message, e);
        this.message = message;
    }

    public CExcetion(Integer code, String message, Throwable e){
        super(message, e);
        this.resultCode = code;
        this.message = message;
    }
}
