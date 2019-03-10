package com.taotao.sso.conterller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.utils.ExceptionUtil;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.sso.service.UserService;

@Controller
public class GettokenCentorler {
	@Autowired
	private UserService userService;
@RequestMapping("/user/token/{token}")
@ResponseBody
public Object getuserBytoken(@PathVariable String token,String callback){
	TaotaoResult result = null;
	
	try {
		result = userService.getuserBytoken(token);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
	}
	if(StringUtils.isBlank(callback)){
		return result;
	}else{
		MappingJacksonValue mappingJacksonValue =new MappingJacksonValue(result);
		mappingJacksonValue.setJsonpFunction(callback);
		return mappingJacksonValue;
	}
	
}
}
