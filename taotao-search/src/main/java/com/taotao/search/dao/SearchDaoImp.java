package com.taotao.search.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;

import com.taotao.search.pojo.Item;
import com.taotao.search.pojo.SearchResult;

public class SearchDaoImp implements SearchDao {

	@Autowired
	private SolrServer solrService;
	public SearchResult search(SolrQuery query) throws Exception {
		// TODO Auto-generated method stub
		SearchResult result = new SearchResult();
		QueryResponse queryResponse = solrService.query(query);
		//取出查询结果
		SolrDocumentList documentlist = queryResponse.getResults();
		result.setRecordCount(documentlist.getNumFound());
		List<Item> itemlist = new ArrayList<>();
			
		//取高显
	Map<String,Map<String,List<String>>> highlighting = queryResponse.getHighlighting();
	for(SolrDocument sorldocument :documentlist){
		Item item = new Item();
		List<String> list = highlighting.get(sorldocument.get("id")).get("item_title");
		String title="";
		//System.out.println(list.size());
		if(list!=null&&list.size()>0){
			title = list.get(0);
		}
		item.setId((String)sorldocument.get("id"));
		//System.out.println(item.getId());
		item.setTitle(title);
		item.setImage((String)sorldocument.get("item_image"));
		item.setPrice((long)sorldocument.get("item_price"));
		item.setSell_point((String) sorldocument.get("item_sell_point"));
		item.setCategory_name((String) sorldocument.get("item_category_name"));
		//添加的商品列表
		itemlist.add(item);

	}
	result.setItemList(itemlist);
	return result;
	
	
	
	}
}
