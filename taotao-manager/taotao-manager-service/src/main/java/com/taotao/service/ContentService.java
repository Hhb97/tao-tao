package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentService {
	public EUDataGridResult getContentlist(int page,int rows ,long categoryId);
	public TaotaoResult insertContent(TbContent content);
	}
