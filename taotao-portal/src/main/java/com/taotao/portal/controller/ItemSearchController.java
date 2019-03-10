package com.taotao.portal.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taotao.common.pojo.SearchResult;
import com.taotao.portal.service.ItemSearch;



@Controller
public class ItemSearchController {
	@Autowired
	ItemSearch itemSearch;
	@RequestMapping("/search")
	public String itemList(@RequestParam("q")String queryString, @RequestParam(defaultValue="1")Integer page, Model model) throws UnsupportedEncodingException{
		if (queryString != null) {
			try {
				queryString = new String(queryString.getBytes("iso8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		SearchResult result=itemSearch.getItemList(queryString,page);
		model.addAttribute("query", queryString);
		model.addAttribute("totalPages", result.getPageCount());
		model.addAttribute("itemList", result.getItemList());
		model.addAttribute("page", page);
		
		return "search";

		
	}
}
