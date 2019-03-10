package com.taotao.rest.contorller;

import java.awt.PageAttributes.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.utils.JsonUtils;
import com.taotao.rest.pojo.ItemCatResult;
import com.taotao.rest.service.ItemCatService;
import com.taotao.rest.service.ItemCatServiceImp;
import org.springframework.http.*;
@Controller
@RequestMapping("/rest")
public class ItemCatListContorller {
	@Autowired
	private ItemCatService itemCatService;
	@RequestMapping(value="/itemcat/all",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody()
	public String getItemCatAll(String callback){
		ItemCatResult resutl = itemCatService.queryAllCategory();
		String jsonrRestul = JsonUtils.objectToJson(resutl);
		String  resultstr =callback+"("+jsonrRestul+");";
		return resultstr;
		
	}
}
