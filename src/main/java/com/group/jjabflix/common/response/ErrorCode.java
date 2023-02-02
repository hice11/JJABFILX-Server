package com.group.jjabflix.common.response;

public enum ErrorCode {

    INVALID_TOKEN(403, "AUTH0", "올바르지 않은 토큰 입니다."),
    EXPIRED_TOKEN(403, "AUTH1", "만료된 토큰 입니다.");

    private final int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
