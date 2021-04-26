package com.hanjie.common.exception;


import com.hanjie.common.http.EnumStatus;

/**
 * 处理切面进行返回的错误
 */
public class PermException extends RuntimeException{

    private EnumStatus enumStatus;

    public PermException(EnumStatus enumStatus) {
        this.enumStatus = enumStatus;
    }

    public EnumStatus getEnumStatus() {
        return enumStatus;
    }

    public void setEnumStatus(EnumStatus enumStatus) {
        this.enumStatus = enumStatus;
    }
}
