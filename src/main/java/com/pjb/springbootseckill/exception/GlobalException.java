package com.pjb.springbootseckill.exception;

import com.pjb.springbootseckill.result.CodeMsg;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class GlobalException extends RuntimeException  implements Serializable {

    private final transient CodeMsg codeMsg;

    public GlobalException(CodeMsg codeMsg) {
        super(codeMsg.toString());
        this.codeMsg = codeMsg;
    }
}
