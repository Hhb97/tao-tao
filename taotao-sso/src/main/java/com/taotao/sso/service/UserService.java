
package com.taotao.sso.service;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbUser;

public interface UserService {
	public TaotaoResult checkData(String content,Integer type);
	public TaotaoResult createUser(TbUser tbuser);
	public TaotaoResult userLogin(String username,String passwrod);
	public TaotaoResult getuserBytoken(String token);
}
