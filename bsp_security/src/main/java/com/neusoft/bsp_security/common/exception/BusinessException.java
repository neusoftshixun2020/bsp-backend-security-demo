package com.neusoft.bsp_security.common.exception;

public class BusinessException extends RuntimeException {
    public static final BusinessException NOT_EXISTS = new BusinessException(504, "doesn't exist", new Object[0]);
    public static final BusinessException PRODUCT_NOT_EXISTS = new BusinessException(504, "product doesn't exist", new Object[0]);
    public static final BusinessException PASSWORD_WRONG = new BusinessException(504, "password wrong", new Object[0]);
    public static final BusinessException INSERT_FAIL = new BusinessException(504, "add operation failed", new Object[0]);
    public static final BusinessException UPDATE_FAIL = new BusinessException(504, "update operation failed", new Object[0]);
    public static final BusinessException DELETE_FAIL = new BusinessException(504, "delete operation failed", new Object[0]);
    public static final BusinessException USERID_NULL_ERROR = new BusinessException(504, "userid cannot be null", new Object[0]);
    public static final BusinessException UPLOAD_FILE_FAIL = new BusinessException(504, "file upload failed", new Object[0]);
    public static final BusinessException FILETYPE_NOT_PICTURE = new BusinessException(504, "file type is not picture", new Object[0]);
    public static final BusinessException OPERATION_FAIL = new BusinessException(504, "operation failed", new Object[0]);
    public static final BusinessException NO_LOGIN = new BusinessException(504, "You need to login", new Object[0]);
    public static final BusinessException PERMISSION_TOKEN_EXPIRED = new BusinessException(504, "permission token expired", new Object[0]);
    public static final BusinessException PERMISSION_TOKEN_INVALID = new BusinessException(504, "permission token invalid", new Object[0]);

    int code;
    String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BusinessException() {}

    public BusinessException(int code, String msg, Object... args) {
        super(String.format(msg, args));
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException newInstance(String code, String msg, Object... args) {
        return new BusinessException(this.code, this.msg, args);
    }
}
