package com.taotao.sso.conterller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.utils.ExceptionUtil;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.sso.service.UserService;

@Controller
public class UserLoginContorller {
@Autowired
private UserService userSrvice;
@RequestMapping("/user/login")
@ResponseBody
public TaotaoResult login(String username,String password){
	System.out.println("lognin"+username);
	try {
		TaotaoResult result = userSrvice.userLogin(username, password);
		return result;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
	}
	
}
}
