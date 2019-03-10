package com.taotao.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample.Criteria;
@Service
public class ContentCategroyServiceImp implements ContentCategroyService {
	@Autowired
	private TbContentCategoryMapper tbContentCategoruyMapper;
	
	@Override
	public List getCategryList(long parentId) {
		TbContentCategoryExample example = new TbContentCategoryExample();
		com.taotao.pojo.TbContentCategoryExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> list= tbContentCategoruyMapper.selectByExample(example);
		List restul = new ArrayList<>();
		for(TbContentCategory tbContentCategory:list){Map node = new HashMap();
		node.put("id", tbContentCategory.getId());
		node.put("text", tbContentCategory.getName());
		node.put("state", tbContentCategory.getIsParent()?"closed":"open");
		restul.add(node);
		}
		return restul;
	}

	@Override
	public TaotaoResult insertContentCat(long parentId, String name) {
		// TODO Auto-generated method stub
		TbContentCategory tbContentCategory =new TbContentCategory();
		tbContentCategory.setParentId(parentId);
		tbContentCategory.setName(name);
		tbContentCategory.setIsParent(false);
		tbContentCategory.setStatus(1);
		tbContentCategory.setCreated(new Date());
		tbContentCategory.setUpdated(new Date());
		tbContentCategory.setSortOrder(1);
		tbContentCategoruyMapper.insert(tbContentCategory);
		TbContentCategory parentCat = tbContentCategoruyMapper.selectByPrimaryKey(parentId);
		if(!parentCat.getIsParent()){
			parentCat.setIsParent(true);
			tbContentCategoruyMapper.updateByPrimaryKey(parentCat);
		}
		return TaotaoResult.ok(tbContentCategory);
	}

	@Override
	public TaotaoResult deleteContentCat(long parentId, long id) {
		// TODO Auto-generated method stub
		System.out.println("进入service");
		TbContentCategoryExample example = new TbContentCategoryExample();
		com.taotao.pojo.TbContentCategoryExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> list= tbContentCategoruyMapper.selectByExample(example);
		if(list.isEmpty()){
			TbContentCategory parentCat = tbContentCategoruyMapper.selectByPrimaryKey(parentId);
			parentCat.setIsParent(false);
			System.out.println("进入if");
		}
		tbContentCategoruyMapper.deleteByPrimaryKey(id);
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult renameContentCat( long id,String name) {
		// TODO Auto-generated method stub
		TbContentCategory tbContentCategory  = tbContentCategoruyMapper.selectByPrimaryKey(id);
		tbContentCategory.setName(name);
		tbContentCategoruyMapper.updateByPrimaryKey(tbContentCategory);
		return TaotaoResult.ok();
	}

	
	

}
