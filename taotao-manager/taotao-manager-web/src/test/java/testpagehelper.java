import org.springframework.context.*;

import java.util.List;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.*;
import com.taotao.pojo.*;
import com.taotao.pojo.TbItemExample;
public class testpagehelper {
	
	public void testpagehelper(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-*.xml");
		TbItemMapper tbitem = applicationContext.getBean(TbItemMapper.class);
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(1,3);
		List<TbItem> list =tbitem.selectByExample(example);
		for (TbItem t: list){
			System.out.println(t.getTitle());
		}
		PageInfo<TbItem>  pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		System.out.println(total);
	}
}
