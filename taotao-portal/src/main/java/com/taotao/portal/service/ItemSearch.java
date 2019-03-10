package com.taotao.portal.service;

import org.apache.solr.client.solrj.SolrQuery;

import com.taotao.common.pojo.SearchResult;

public interface ItemSearch {
	public SearchResult getItemList(String query,int page);
}
