package com.taotao.portal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.noggit.JSONUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.JsonUtils;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbContent;

@Service
public class ContentServiceImp implements ContentService {

	public String getContetnlist() {
		// TODO Auto-generated method stub
		String result = HttpClientUtil.doGet("http://localhost:8081/rest/content/list/89");
		System.out.println(result);
		try{
			TaotaoResult taotaoResult = TaotaoResult.formatToList(result, TbContent.class);
			List<TbContent> list = (List<TbContent>) taotaoResult.getData();
			List<Map> resultlist = new ArrayList<>();
	
			for(TbContent tbContent:list){
				Map map = new HashMap<>();
			
				map.put("src", tbContent.getPic());
				map.put("height", 240);
				map.put("width", 670);
				map.put("srcB", tbContent.getPic2());
				map.put("widthB", 550);	
				map.put("heightB", 240);
				map.put("href", tbContent.getUrl());
				map.put("alt", tbContent.getSubTitle());
				resultlist.add(map);
			}
			return JsonUtils.objectToJson(resultlist);
			}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
		return null;
	}

}
