package com.group.jjabflix.config.security.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group.jjabflix.error.ErrorCode;
import com.group.jjabflix.error.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;

    @Override
    public void commence
            (HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {

        log.info("JWT 인증 예외 발생 Request URI : {}", request.getRequestURI());

        ErrorCode jwtErrorCode = (ErrorCode) request.getAttribute("exception");
        ErrorResponse errorResponse = null;

        if (jwtErrorCode != null) {
            log.info("JWT 예외 타입 : {}", jwtErrorCode.name());
            errorResponse = ErrorResponse.of(jwtErrorCode);
        } else {
            errorResponse = ErrorResponse.of(ErrorCode.INVALID_TOKEN);
        }

        String responseBody = objectMapper.writeValueAsString(errorResponse);

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(response.getStatus());
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseBody);
    }

}
