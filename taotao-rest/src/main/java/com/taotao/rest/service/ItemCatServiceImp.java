package com.taotao.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.rest.pojo.ItemCat;
import com.taotao.rest.pojo.ItemCatResult;
@Service
public class ItemCatServiceImp implements ItemCatService {
	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	public ItemCatResult queryAllCategory() {
		// TODO Auto-generated method stub
		ItemCatResult result = new ItemCatResult();
		result.setData(getItemCatList(0));
		return result;
	}

	private List<?> getItemCatList(long parentId){
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
		List item = new ArrayList();
		for(TbItemCat tbItemCat :list){
			if(tbItemCat.getIsParent()){
			ItemCat itemCat = new ItemCat();
			itemCat.setUrl("/category/"+tbItemCat.getId()+".html");
			itemCat.setName(tbItemCat.getName());
			itemCat.setItem(getItemCatList(tbItemCat.getId()));
			item.add(itemCat);
			}
			else {
				String catItem ="/item/"+tbItemCat.getId()+".html|"+tbItemCat.getName();
				item.add(catItem);
			}
		}
		return item;
		
	}

}
