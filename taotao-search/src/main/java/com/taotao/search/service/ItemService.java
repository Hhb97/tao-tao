package com.taotao.search.service;

import java.io.IOException;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.search.pojo.SearchResult;

public interface ItemService {
	public TaotaoResult importAllItems()throws Exception, IOException ;
	public SearchResult search(String queryString,int page,int rows);
}
