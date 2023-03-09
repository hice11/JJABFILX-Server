package com.group.jjabflix.profile.exception;

import com.group.jjabflix.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExistProfileNameException extends RuntimeException {

    private ErrorCode errorCode;

}
