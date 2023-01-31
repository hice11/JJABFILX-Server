package com.group.jjabflix.config.security;

import com.group.jjabflix.config.security.jwt.JwtAuthenticationFilter;
import com.group.jjabflix.config.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtProvider jwtProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable() // httpBasic 방식 해제
                .csrf().disable() // CSRF 설정 해제
                .addFilter(corsFilter()) // CORS 허용
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션 사용X
                .and()
                .authorizeRequests() // 조건별로 요청 허용/제한 설정
                //.antMatchers("/api/v1/auth/signup", "/api/v1/logout").hasRole("TEMPORARY_USER")
                .antMatchers("/api/v1/auth/**").permitAll() // 로그인, 회원가입, pw 찾기는 모두 허용
                .antMatchers("/api/v1/test").hasRole("USER") // USER 권한이 있는 유저에게만 허용
                //.anyRequest().authenticated() // 이 밖에 모든 요청에 대해서 인증이 필요
                .anyRequest().permitAll() // test // 해당 API에 대해서는 모든 요청을 허가
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // CORS 허용
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        source.registerCorsConfiguration("/api/**",config);

        CorsFilter corsFilter = new CorsFilter(source);
        return corsFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
