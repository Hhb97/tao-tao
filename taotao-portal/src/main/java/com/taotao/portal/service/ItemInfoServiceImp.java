package com.taotao.portal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taotao.portal.service.*;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.taotao.common.pojo.Item;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.JsonUtils;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbUserExample.Criteria;
@Service
public class ItemInfoServiceImp implements ItemInfoService {
	
	@Override
	public Tbitemifno getItemInfo(long id) {
		// TODO Auto-generated method stub
		String result = HttpClientUtil.doGet("http://localhost:8081/iteminfo/"+id);
		System.out.println(result);
		TaotaoResult ret = TaotaoResult.formatToPojo(result, Tbitemifno.class);
		Tbitemifno iteminof=(Tbitemifno) ret.getData();
			
		if(iteminof!=null){
			return iteminof;
		}
			
		
		return null;
		}

	@Override
	public String getitemdesc(long id) {
		// TODO Auto-generated method stub
		String result = HttpClientUtil.doGet("http://localhost:8081/item/desc/"+id);
		System.out.println(result);
		TaotaoResult ret = TaotaoResult.formatToPojo(result, TbItemDesc.class);
		TbItemDesc itemdesc=(TbItemDesc) ret.getData();
		String result1 = itemdesc.getItemDesc();
		
			
		
		return result1;
		}

	
	
	}
	




