package com.taotao.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.TbItemCat;
import com.taotao.service.ItemCatService;
		
@Controller
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List ItemCatList(@RequestParam(value="id",defaultValue="0")long parentId) throws Exception{
		List Alist = new ArrayList<>();
		List <TbItemCat> list = itemCatService.getItemCatlist(parentId);
		for(TbItemCat tbItemCat:list){
			Map node = new HashMap();
			node.put("id", tbItemCat.getId());
			node.put("text", tbItemCat.getName());
			node.put("state", tbItemCat.getIsParent()?"closed":"open");
			Alist.add(node);
		}
		return Alist;
		
	}
}
