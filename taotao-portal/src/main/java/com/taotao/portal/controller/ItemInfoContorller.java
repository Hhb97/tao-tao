package com.taotao.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.Item;
import com.taotao.portal.service.ItemInfoService;
import com.taotao.portal.service.ItemInfoServiceImp;
import com.taotao.portal.service.Tbitemifno;

@Controller
public class ItemInfoContorller {
	@Autowired
	private ItemInfoServiceImp itemInfoService;
@RequestMapping("/item/{id}")
public String inteminfo(@PathVariable long id,Model model){
	Tbitemifno item = itemInfoService.getItemInfo(id);
	model.addAttribute("item", item);
	return "item";
}
@RequestMapping(value="/item/desc/{id}",produces=MediaType.TEXT_HTML_VALUE+";charset=utf-8")
@ResponseBody
public String getdesc(@PathVariable long id){
	String result=itemInfoService.getitemdesc(id);
	return result;
}
}

