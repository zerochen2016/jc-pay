package jc.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/page")
	public String page() {
		return "test";
	}
	
	@ResponseBody
	@RequestMapping("/api")
	public String api() {
		return "api";
	}
}
