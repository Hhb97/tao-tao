package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PageController {
	@RequestMapping("/")
	public String showIndex(){
		System.out.println("进入");
		return "index";
	}
	@RequestMapping("/{page}")
	public String showpage (@PathVariable String page){
		return page;
	}
}
