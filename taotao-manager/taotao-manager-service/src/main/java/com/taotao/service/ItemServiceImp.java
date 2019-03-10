package com.taotao.service;

import java.util.Date;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.*;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.mapper.*;
@Service
public class ItemServiceImp implements ItemService {
	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemDescMapper itemdescMapper;
	@Autowired
	private TbItemParamItemMapper tbItemParamItemMapper;
	@Override
	public TbItem getItemById(long itemId) {
		// TODO Auto-generated method stub
		TbItemExample example = new TbItemExample();
		//TbItem item = itemMapper.selectByPrimaryKey(itemId);
	Criteria criteria =	example.createCriteria();
	criteria.andIdEqualTo(itemId);
	List<TbItem> item = itemMapper.selectByExample(example);
	if(item !=null){
		return item.get(0);
	}
		return null;
	}

	@Override
	public EUDataGridResult getItemList(int page, int rows) {
		// TODO Auto-generated method stub
		System.out.println("getitelis5t");
		EUDataGridResult eurs =new EUDataGridResult();
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(page, rows);
		List<TbItem> list =itemMapper.selectByExample(example);
		PageInfo<TbItem>  pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		eurs.setTotal(total);
		eurs.setRows(list);
		return eurs;
	}

	@Override
	public TaotaoResult saveItem(TbItem tbItem,String desc,String itemparam) throws Exception {
		// TODO Auto-generated method stub
		tbItem.setStatus((byte) 1);
		tbItem.setCreated(new Date());
		tbItem.setUpdated(new Date());
		itemMapper.insert(tbItem);
		TaotaoResult result =insertItemDesc(tbItem.getId(), desc);
		
		result = saveItemParamItem(tbItem.getId(), itemparam);
		try {
			HttpClientUtil.doGet("http://localhost:8083/search/manager/importall");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	public TaotaoResult insertItemDesc(long itemid,String desc){
		TbItemDesc itemDesc = new TbItemDesc();
		System.out.println(itemid+desc);
		itemDesc.setItemId(itemid);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		itemdescMapper.insert(itemDesc);
		return TaotaoResult.ok();

		
	}
	
	public TaotaoResult saveItemParamItem(long itemid, String itemparam) {
		System.out.println("ok"+itemid);
		TbItemParamItem itemParamItem = new TbItemParamItem();
		itemParamItem.setItemId(itemid);
		itemParamItem.setParamData(itemparam);
		itemParamItem.setCreated(new Date());
		itemParamItem.setUpdated(new Date());
		//向表中插入数据
		
		tbItemParamItemMapper.insert(itemParamItem);
		
		return TaotaoResult.ok();

	}
}
