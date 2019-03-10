package com.taotao.rest.contorller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentCategory;
import com.taotao.rest.dao.JedisClient;
import com.taotao.rest.service.ContentService;




@Controller
@RequestMapping("/rest/content")

public class ContentContorller {
	@Autowired
	ContentService contentService;
	@Autowired
	JedisClient jedisClent;
	@RequestMapping("/list/{contentCategoryId}")
	@ResponseBody
	public TaotaoResult getContentList(@PathVariable Long contentCategoryId) {
		System.out.println("jilai");
		try {
			String result = jedisClent.hget("hkey1", "cid");
			if(StringUtils.isBlank(result)){
				TaotaoResult toato=TaotaoResult.formatToPojo(result, TbContentCategory.class);
				return toato;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		List<TbContent> list = contentService.getContentlist(contentCategoryId);
		System.out.println(list.get(0));
		return TaotaoResult.ok(list);
	}

}
