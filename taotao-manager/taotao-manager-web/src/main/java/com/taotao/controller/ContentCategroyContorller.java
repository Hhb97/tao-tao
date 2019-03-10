package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.service.ContentCategroyService;

@Controller
@RequestMapping("/content/category")
public class ContentCategroyContorller {
	@Autowired
	private ContentCategroyService contentCategroyService;
	@RequestMapping("/list")
	@ResponseBody
	public List<?> getContentCat(@RequestParam(value="id",defaultValue="0")long parentId){
		System.out.print("aaa");
		List resutl = contentCategroyService.getCategryList(parentId);
		return resutl;
		
	}
	@RequestMapping("/create")
	@ResponseBody
	public TaotaoResult createContentCat(long parentId,String name){
		System.out.println("parentID="+parentId);
		TaotaoResult result  = contentCategroyService.insertContentCat(parentId, name);
		return result;
		
	}
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult deleteContentCat(long parentId,long id){
		TaotaoResult result = contentCategroyService.deleteContentCat(parentId, id);
		return result;
	}
	@RequestMapping("/update")
	@ResponseBody
	public TaotaoResult updateContentCat(long id ,String name){
		TaotaoResult result = contentCategroyService.renameContentCat(id, name);
		return result;
	}
}
