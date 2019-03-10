package com.taotao.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.portal.service.ContentService;

@Controller
public class PageController {
	@Autowired
	ContentService contentService;
	@RequestMapping("/index")
	public String showIndex(Model model){
		String adjson = ((ContentService) contentService).getContetnlist();
		model.addAttribute("ad1", adjson);
		return "index";
	}
	@RequestMapping("/showLogin")
	public String showpage (){
		return "login";
	}
}
