package com.group.jjabflix.config.security.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group.jjabflix.error.ErrorCode;
import com.group.jjabflix.error.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private final ObjectMapper objectMapper;

    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException accessDeniedException)
            throws IOException, ServletException {

        log.info("JWT 인가(권한) 예외 발생 Request URI : {}", request.getRequestURI());

        ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.ACCESS_DENIED);

        String responseBody = objectMapper.writeValueAsString(errorResponse);

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(response.getStatus());
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseBody);

    }

}
