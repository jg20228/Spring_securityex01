package com.cos.securityex01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	@GetMapping({"/",""})
	public String index() {
		return "인덱스 페이지 입니다";
	}
	@GetMapping({"/user"})
	public String user() {
		return "유저 페이지 입니다";
	}
	@GetMapping({"/admin"})
	public String admin() {
		return "어드민 페이지 입니다";
	}
	@GetMapping({"/login"})
	public String login() {
		return "로그인 페이지 입니다";
	}
	
}
