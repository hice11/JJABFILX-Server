package com.group.jjabflix.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {

    private int status;
    private String code;
    private String message;
    private T result;

    //성공일 때
    public static <T> ApiResponse<T> ok(T result) {
        return new ApiResponse<>(200, null,"ok", result);
    }

    //error
    public static <T> ApiResponse<T> fail(ErrorCode errorCode) {
        return new ApiResponse<>(errorCode.getStatus(), errorCode.getCode(), errorCode.getMessage(), null);
    }

}
