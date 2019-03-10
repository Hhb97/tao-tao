package com.taotao.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemParamExample.Criteria;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
@Service
public class ItemParamServiceImp implements ItemParameService {
	@Autowired 
	private TbItemParamMapper tbItemParamMapper;
	@Autowired
	private TbItemParamItemMapper tbItemParamItem;
	@Override
	public TaotaoResult getItemParamByCid(long cid) {
		// TODO Auto-generated method stub
		TbItemParamExample example = new TbItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		
		List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(example);
		System.out.println(list);
		if(list!=null&&list.size()>0){
			System.out.println(list.get(0).getParamData());
			return TaotaoResult.ok(list.get(0));
		}
		return TaotaoResult.ok();
	}
	public TaotaoResult saveItemParam(TbItemParam itemParam){
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		tbItemParamMapper.insert(itemParam);
		
		return TaotaoResult.ok();
		
	}
	
}
