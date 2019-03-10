package com.taotao.mapper;

import java.util.List;

import com.taotao.common.pojo.Item;



public interface ItemMapper {
	List<Item>getItemList();
	Item getById(long id);
}
