
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.utils.ExceptionUtil;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.rest.dao.JedisClient;
@Service
public class RedisServiceImp implements RedisService {
	@Autowired
	private JedisClient jedisClient;
	@Override
	public TaotaoResult syncContent(long contentcid) {
		// TODO Auto-generated method stub
		try{
			jedisClient.hdel("hkey",contentcid+"");
		}catch(Exception e){
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return TaotaoResult.ok();
	}

}*/
