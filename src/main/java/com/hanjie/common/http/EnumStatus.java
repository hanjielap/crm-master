package com.hanjie.common.http;


public enum EnumStatus {

    OK(20000, "操作成功"),
    ERROR(40000, "小奥做失败"),
    NO_LOGIN(33333, "未登录"),
    ACCOUNT_ERROR(22222, "用户名或者邮箱不正确"),
    CODE_ERROR(22223, "验证码不正确"),
    CODE_SHIXIAO(22224, "验证码已失效"),
    NO_ACTIVE(22225, "用户未激活"),
    FORM_VALICATOR_ERROR(33233, "表单校验失败"),
    IMG_NO_UPLOAD(2223344, "上传的不是一个图片"),
    IMG_NO(22331, "上传格式不正确"),
    IMG_NO_MAX(22332, "上传文件太大"),
    ;

    private int status;

    private String message;

    EnumStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
