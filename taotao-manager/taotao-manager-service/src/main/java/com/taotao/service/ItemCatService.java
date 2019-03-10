package com.taotao.service;

import java.util.List;

import com.taotao.pojo.TbItemCat;

public interface ItemCatService {
	public List<TbItemCat> getItemCatlist(long parentId) throws Exception;
}
