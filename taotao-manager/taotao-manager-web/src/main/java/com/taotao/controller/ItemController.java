package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.*;
import com.taotao.service.ItemServiceImp;

@Controller
public class ItemController<TaotaoResul> {
	@Autowired
	private ItemService itemService;
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItemlist(Integer page,Integer rows){
		
		
			
		
		EUDataGridResult result =itemService.getItemList(page, rows);
		
		
		return result;
		
	}
	@RequestMapping("/item/save")
	@ResponseBody
	public TaotaoResul saveItem(TbItem tbItem,String desc,String itemParams) throws Exception{
		System.out.println(itemParams);
		TaotaoResult resutl  = itemService.saveItem(tbItem,desc,itemParams);
		return (TaotaoResul) resutl;
		
	}
	
}
