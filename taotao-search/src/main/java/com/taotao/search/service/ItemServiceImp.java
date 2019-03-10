package com.taotao.search.service;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.utils.ExceptionUtil;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.search.dao.SearchDao;
import com.taotao.search.mapper.ItemMapper;
import com.taotao.search.pojo.Item;
import com.taotao.search.pojo.SearchResult;
@Service
public class ItemServiceImp implements ItemService {
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private SolrServer solrServer;
	@Autowired
	private SearchDao searchDao;
	@Override
	public TaotaoResult importAllItems() throws Exception, IOException {
		// TODO Auto-generated method stub
		try{
		List<Item> list = itemMapper.getItemList();
		for(Item item:list){
			SolrInputDocument document = new SolrInputDocument();
			System.out.println(item.getId());
			document.setField("id", item.getId());
			document.setField("item_title", item.getTitle());
			document.setField("item_sell_point", item.getSell_point());
			document.setField("item_price", item.getPrice());
			document.setField("item_image", item.getImage());
			document.setField("item_category_name", item.getCategory_name());
			document.setField("item_desc", item.getItem_des());
			//写入索引库
			solrServer.add(document);

		}
		solrServer.commit();
		}
		catch(Exception e){
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return TaotaoResult.ok();
	}
	@Override
	public SearchResult search(String queryString, int page, int rows) {
		// TODO Auto-generated method stub
		SolrQuery query = new SolrQuery();
		query.setQuery(queryString);
		query.setStart((page-1)*rows);
		query.setRows(rows);
		query.set("df","item_keywords");//设置默认搜索域
		//设置高亮显示
		query.setHighlight(true);
		query.addHighlightField("item_title");
		query.setHighlightSimplePre("<em style=\"color:red\">");
		query.setHighlightSimplePost("</em>");
		SearchResult result=null;
		try {
			System.out.println("result = searchDao.search(query);");
			result = searchDao.search(query);
			long recordCount = result.getRecordCount();
			long pagecount = recordCount/rows;
			if(recordCount%rows>0){
				pagecount++;
			}
			result.setPageCount(pagecount);
			result.setCurPage(page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
