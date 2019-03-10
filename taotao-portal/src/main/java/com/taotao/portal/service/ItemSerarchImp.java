package com.taotao.portal.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.HttpClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.instrument.classloading.tomcat.TomcatLoadTimeWeaver;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.SearchResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.TaotaoResult;
@Service
public class ItemSerarchImp implements ItemSearch {

	@Override
	public SearchResult getItemList(String query,int page) {
		// TODO Auto-generated method stub
		Map<String,String> param = new HashMap<>();
		param.put("q", query);
		param.put("page", page+"");
		try {
			String result = HttpClientUtil.doGet("http://localhost:8083/search/query",param);
			TaotaoResult taotaoResult = TaotaoResult.formatToPojo(result, SearchResult.class);
			if(taotaoResult.getStatus()==200){
				SearchResult searchResult = (SearchResult) taotaoResult.getData();
				return searchResult;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		//String result = HttpClientUtil.doGet("http://localhost:8083/search/query",param);
		//System.out.println(result);
		return null;
	}


}
