package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParameService;

@Controller
@RequestMapping("/item/param")
public class ItemParamController {
	@Autowired
	private ItemParameService itemParameService;
	@RequestMapping("/query/itemcatid/{itemCatId}")
	@ResponseBody
	public TaotaoResult getItemParamBycid(@PathVariable long itemCatId){
		System.out.println("jil");
		TaotaoResult result = itemParameService.getItemParamByCid(itemCatId);
		return result;
		
	}
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public TaotaoResult saveItemParam(@PathVariable long cid,String paramData){
		
		System.out.println("aaaa"+paramData);
		TbItemParam itemParam = new TbItemParam();
		itemParam.setItemCatId(cid);
		System.out.println(paramData);
		itemParam.setParamData(paramData);
		TaotaoResult result = itemParameService.saveItemParam(itemParam);
		return result;
		
	}
}
