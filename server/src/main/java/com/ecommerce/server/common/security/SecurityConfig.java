package com.ecommerce.server.common.security;

import com.ecommerce.server.common.jwt.JwtAccessDeniedHandler;
import com.ecommerce.server.common.jwt.JwtAuthenticationEntryPoint;
import com.ecommerce.server.common.jwt.JwtSecurityConfig;
import com.ecommerce.server.common.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()

                //excoption handler에 커스텀 클래스 추가
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                //세션을 사용하지 않기 때문에 세션설정을 stateless로 설정
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                //auth 관련 api는 토큰없이 접근가능, 나머지는 접근불가
                .and()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()

                //커스텀 JwtFilter 적용
                .and()
                .apply(new JwtSecurityConfig(tokenProvider));
    }
}
