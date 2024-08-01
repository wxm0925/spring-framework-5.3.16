package com.wxm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wenxiangmin
 * @ClassName HelloController.java
 * @Description TODO
 * @createTime 2024年04月21日 19:57:00
 */
@Controller
public class HelloController {
	@GetMapping("hello")
	public String hello () {
		System.out.println(121);
		return "index";
	}
}
