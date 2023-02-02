package com.group.jjabflix.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse {

    private int status;
    private String code;
    private String message;
    private Result result;

    //성공일 때
    public static ApiResponse ok(Result result) {
        return new ApiResponse(200, null,"ok", result);
    }

    //error
    public static ApiResponse fail(ErrorCode errorCode) {
        return new ApiResponse(errorCode.getStatus(), errorCode.getCode(), errorCode.getMessage(), null);
    }

}
