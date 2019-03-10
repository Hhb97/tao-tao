package com.taotao.portal.service;

import com.taotao.pojo.TbItem;

public class Tbitemifno extends TbItem{
	public String[] getImages() {
		String image=getImage();
		if (image != null) {
			String[] images = image.split(",");
			return images;
		}
		return null;
	}
}
