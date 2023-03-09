package com.group.jjabflix.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // common
    INTERNAL_SERVER_ERROR(500, "C001", "정의되지 않은 에러가 발생했습니다."),
    EXPIRED_TOKEN(401, "C002", "만료된 토큰 입니다."),
    INVALID_TOKEN(401, "C003", "잘못된 토큰 입니다."),
    ACCESS_DENIED(403, "C004", "접근할 권한이 없습니다."),

    // user
    EMAIL_DUPLICATION(400, "U001", "중복된 이메일이 존재합니다."),
    NOT_FOUND_USER(404, "U002", "존재하지 않는 회원입니다."),
    MAIL_SEND_FAILED(400, "U003", "이메일 전송에 실패했습니다."),
    INVALID_EMAIL(400, "U004", "잘못된 이메일 주소입니다."),

    // profile
    PROFILE_OUT_OF_RANGE(400,"P001","프로필을 더 이상 생성할 수 없습니다."),
    ALREADY_EXIST_PROFILE_NAME(400,"P002","이미 존재하는 프로필 이름 입니다.");

    private final int status;
    private final String code;
    private final String message;

}
