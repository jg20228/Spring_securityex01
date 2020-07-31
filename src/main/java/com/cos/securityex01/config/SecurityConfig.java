package com.cos.securityex01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//설정파일
@Configuration //IoC 빈(bean)객체 등록
@EnableWebSecurity //필터 체인 관리 시작 어노테이션 오버라이딩해서 체인 하나하나를 직접적을 관리가 가능하다.
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소 접근시 권한 및 인증 미리 체크  
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean //여기다가 적어두면 IoC가 되어서 쓰고 싶은곳에서 AutoWired하면 됨
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable(); //csrf 비활성화, form에서 post요청시 주고 받는 토큰
		http.authorizeRequests()
			.antMatchers("/user/**","/admin/**")
			.authenticated()
			.anyRequest()
			.permitAll()
		.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/loginProc")
			.defaultSuccessUrl("/");
		
		
	}
}