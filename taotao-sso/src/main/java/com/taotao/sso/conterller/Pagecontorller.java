package com.taotao.sso.conterller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class Pagecontorller {
	@RequestMapping("/showLogin")
	public String shwologin(String redirect,Model model ){
		model.addAttribute("redirect",redirect);
		return "login";
	}
	@RequestMapping("/showRegister")
	public String shwoRegister(){
		return "register";
	}
}
