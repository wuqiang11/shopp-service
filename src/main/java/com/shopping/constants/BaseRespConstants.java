package com.shopping.constants;

public enum BaseRespConstants {
    NEW_SUCCESS(200,"操作成功"),
    INVIATE_USER_NULL(1000,"邀请用户不存在"),
    VALIDATE_CODE_NULL(1001,"验证码不存在或者已经失效"),
    VALIDATE_CODE_OVERTIME(1002,"验证码已经失效");
    BaseRespConstants(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private  int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
