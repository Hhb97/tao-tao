package com.taotao.sso.conterller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.common.utils.ExceptionUtil;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbUser;
import com.taotao.sso.service.UserService;
import com.taotao.sso.service.UserServiceImp;

@Controller
public class AddUserContorller {
	@Autowired
	private UserService userService;
	@RequestMapping("/user/register")
	public TaotaoResult createUser(TbUser user){
		try {
			TaotaoResult result = userService.createUser(user);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}
