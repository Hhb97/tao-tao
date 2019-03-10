package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentContorller {
	@Autowired
	private ContentService contentService;
	@RequestMapping("/query/list")
	@ResponseBody
	public EUDataGridResult getquerylist(int page,int rows,long categoryId){
		EUDataGridResult result  = new EUDataGridResult();
		result = contentService.getContentlist(page, rows, categoryId);
		return result;
	}
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult SaveContent(TbContent content){
		TaotaoResult result  = contentService.insertContent(content);
		return result;
	}
}
