package com.taotao.rest.service;

import com.taotao.common.utils.TaotaoResult;

public interface ItemService {
	public TaotaoResult getinfo(long id);
	public TaotaoResult getdesc(long id);
	public TaotaoResult getparam(long id);
}
