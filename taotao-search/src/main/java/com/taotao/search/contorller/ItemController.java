package com.taotao.search.contorller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.search.service.ItemService;

@Controller
@RequestMapping("/manager")
public class ItemController {
	@Autowired
	private ItemService itemServie;
	@RequestMapping("/importall")
	@ResponseBody
	public TaotaoResult importallitems() throws IOException, Exception{
		TaotaoResult result  = itemServie.importAllItems();
		return result;
		
	}
}
