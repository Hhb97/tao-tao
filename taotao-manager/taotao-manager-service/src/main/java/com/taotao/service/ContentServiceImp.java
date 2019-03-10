package com.taotao.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.lf5.viewer.categoryexplorer.CategoryExplorerLogRecordFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;
@Service
public class ContentServiceImp implements ContentService {
	@Autowired
	private TbContentMapper tbContentMapper;
	@Override
	public EUDataGridResult getContentlist(int page, int rows, long categoryId) {
		// TODO Auto-generated method stub
		EUDataGridResult eurs = new EUDataGridResult();
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		PageHelper.startPage(page, rows);
		List<TbContent> list = tbContentMapper.selectByExample(example);
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);
		long tatol = pageInfo.getTotal();
		eurs.setTotal(tatol);
		eurs.setRows(list);
		return eurs;
	}
	@Override
	public TaotaoResult insertContent(TbContent content) {
		// TODO Auto-generated method stub
		content.setCreated(new Date());
		content.setUpdated(new Date());
		tbContentMapper.insert(content);
		try {
			HttpClientUtil.doGet("http://localhost:8081/rest/content/"+content.getCategoryId()+"");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return TaotaoResult.ok();
	}

}
