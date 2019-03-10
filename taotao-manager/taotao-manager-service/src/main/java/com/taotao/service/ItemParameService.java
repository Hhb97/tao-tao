package com.taotao.service;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItemParam;

public interface ItemParameService {
	public TaotaoResult getItemParamByCid(long cid);
	public TaotaoResult saveItemParam(TbItemParam itemParam);
	
	
}
