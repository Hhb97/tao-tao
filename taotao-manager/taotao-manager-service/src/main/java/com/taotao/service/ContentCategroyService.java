package com.taotao.service;

import java.util.List;

import com.taotao.common.utils.TaotaoResult;

public interface ContentCategroyService {
	public List getCategryList(long parentId);
	public TaotaoResult insertContentCat(long parentId,String name);
	public TaotaoResult deleteContentCat (long paentId,long id);
	public TaotaoResult renameContentCat (long id,String name);
	
}
