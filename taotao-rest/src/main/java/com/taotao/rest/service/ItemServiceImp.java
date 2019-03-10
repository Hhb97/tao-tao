package com.taotao.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.Item;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.mapper.*;
@Service
public class ItemServiceImp implements ItemService {
	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemDescMapper itemdescmapper;
	@Autowired
	private TbItemParamItemMapper itemparamMapper;
	@Override
	public TaotaoResult getinfo(long id) {
		// TODO Auto-generated method stub
		//Item item=new Item();
	
		TbItem itemd = itemMapper.selectByPrimaryKey(id);
		
		
		return TaotaoResult.ok(itemd);
	}
	@Override
	public TaotaoResult getdesc(long id) {
		// TODO Auto-generated method stub
		TbItemDesc itemdesc =itemdescmapper.selectByPrimaryKey(id);
		return TaotaoResult.ok(itemdesc);
	}
	@Override
	public TaotaoResult getparam(long id) {
		// TODO Auto-generated method stub
		TbItemParamItemExample example = new TbItemParamItemExample();
		com.taotao.pojo.TbItemParamItemExample.Criteria criteria =example.createCriteria();
		criteria.andIdEqualTo(id);
		List<TbItemParamItem> list  = itemparamMapper.selectByExampleWithBLOBs(example);
		if(list!=null&&list.size()!=0){
			TbItemParamItem item= list.get(0);
			return TaotaoResult.ok(item);
		}
		return null;
	}

}
