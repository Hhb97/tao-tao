package com.taotao.rest.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.Item;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.rest.service.ItemService;

@Controller
public class ItemInfoController {
	@Autowired
	private ItemService itemServie;
@RequestMapping("/iteminfo/{id}")
@ResponseBody
public TaotaoResult getItemInfo(@PathVariable long id){
	TaotaoResult result =itemServie.getinfo(id);
	//Item item = (Item) result.getData();
	return result;
}
@RequestMapping("/item/desc/{id}")
@ResponseBody
public TaotaoResult getItemdesc(@PathVariable long id){
	TaotaoResult result =itemServie.getdesc(id);
	//Item item = (Item) result.getData();
	return result;
}
@RequestMapping("/item/param/{id}")
@ResponseBody
public TaotaoResult getItemparam(@PathVariable long id){
	TaotaoResult result =itemServie.getparam(id);
	//Item item = (Item) result.getData();
	return result;
}
}
