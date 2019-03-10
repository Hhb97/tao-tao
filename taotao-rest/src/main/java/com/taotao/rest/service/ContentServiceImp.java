package com.taotao.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;
@Service
public class ContentServiceImp implements ContentService {
	@Autowired
	private TbContentMapper tbContentMapper;
	
	@Override
	public List<TbContent> getContentlist(long contentcid) {
		// TODO Auto-generated method stub
		TbContentExample example = new TbContentExample();
		
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(contentcid);
		List<TbContent>list=tbContentMapper.selectByExample(example);
			return list;
	}

}
