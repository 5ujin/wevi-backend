package com.wevi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                        "/api/members/signup",    // 회원가입 허용
                        "/api/members/login",     // 로그인 허용 (앞으로 만들 경우)
                        "/api/token/refresh",     // 토큰 재발급 허용 (추후용)
                        "/h2-console/**"          // H2 콘솔 허용
                ).permitAll() // H2 콘솔 허용
                .anyRequest().authenticated()
            );

        // 로그인/기본 인증 제거
        http.formLogin(AbstractHttpConfigurer::disable);
        http.httpBasic(AbstractHttpConfigurer::disable);

        // CSRF 예외 처리 (H2, REST API)
        http.csrf(csrf -> csrf
                .ignoringRequestMatchers("/h2-console/**", "/api/**")
        );

        // H2 콘솔 iframe 허용
        http.headers(headers -> headers
                .frameOptions(HeadersConfigurer.FrameOptionsConfig::disable) // X-frame-Options 무효화
        );

        // 인증 실패 시 401 응답 + JSON 반환
        http.exceptionHandling(ex -> ex
                .authenticationEntryPoint((req, res, authException) -> {
                    res.setStatus(401);
                    res.setContentType("application/json; charset=UTF-8");
                    res.getWriter().write("""
                        {
                            "code": "UNAUTHORIZED",
                            "message": "인증이 필요합니다."
                        }
                    """);
                })
        );

        return http.build();
    }
}
