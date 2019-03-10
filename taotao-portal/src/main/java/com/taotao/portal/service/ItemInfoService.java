package com.taotao.portal.service;

import com.taotao.common.pojo.Item;

public interface ItemInfoService {
	public Tbitemifno getItemInfo(long id);
	public String getitemdesc(long id);
	//public String getparam(long id);
}
