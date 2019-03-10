package com.taotao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.pojo.TbItemExample;
@Service
public class ItemCatServiceImp implements ItemCatService {
	@Autowired
	private TbItemCatMapper itemCatMapper;
	@Override
	public List<TbItemCat> getItemCatlist(long parentId) throws Exception {
		// TODO Auto-generated method stub
		TbItemCatExample example= new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		
		return list;
	}

}
