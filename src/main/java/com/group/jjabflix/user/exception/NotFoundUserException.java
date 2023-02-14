package com.group.jjabflix.user.exception;

import com.group.jjabflix.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NotFoundUserException extends IllegalArgumentException {

    private ErrorCode errorCode;
}
