package com.taotao.sso.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.support.json.JSONUtils;
import com.taotao.common.utils.JsonUtils;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;
import com.taotao.pojo.TbUserExample.Criteria;
import com.taotao.sso.dao.redisClent;
@Service
public class UserServiceImp implements UserService {
	@Autowired
	private TbUserMapper tbUserMapper;
	@Autowired
	private redisClent redisclent;
	public TaotaoResult checkData(String content, Integer type) {
		// TODO Auto-generated method stub
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		if(type==1){
			criteria.andUsernameEqualTo(content);
		}else if(type==2){
			criteria.andPhoneEqualTo(content);
		}else if(type==3){
			criteria.andEmailEqualTo(content);
		}
		List<TbUser> list = tbUserMapper.selectByExample(example);
		if(list==null|| list.size()==0){
			return TaotaoResult.ok(true);
		}
		return TaotaoResult.ok(false);
	}
	@Override
	public TaotaoResult createUser(TbUser tbuser) {
		// TODO Auto-generated method stub
		tbuser.setCreated(new Date());
		tbuser.setUpdated(new Date());
		tbuser.setPassword(org.springframework.util.DigestUtils.md5DigestAsHex(tbuser.getPassword().getBytes()));
		tbUserMapper.insert(tbuser);
		return null;
	}
	@Override
	public TaotaoResult userLogin(String username, String passwrod) {
		System.out.println("userlogin");
		// TODO Auto-generated method stub
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<TbUser> list = tbUserMapper.selectByExample(example);
		if(null==list||list.size()==0){
			return TaotaoResult.build(400, "用户名密码错误");
		}
		TbUser user=list.get(0);
		System.out.println(user.getPassword());
		if(!org.springframework.util.DigestUtils.md5DigestAsHex(passwrod.getBytes()).equals(user.getPassword())){
			return TaotaoResult.build(400, "用户名密码错误");
		}
		String token = UUID.randomUUID().toString();
		user.setPassword(null);
		redisclent.set(token,JsonUtils.objectToJson(user));
		redisclent.expire(token,100000);
		System.out.println("ok");
		return TaotaoResult.ok(token);
	}
	@Override
	public TaotaoResult getuserBytoken(String token) {
		// TODO Auto-generated method stub
		String json = redisclent.get(token);
		if(StringUtils.isBlank(json)){
			return TaotaoResult.build(500, "sesson is over");
		}
		redisclent.expire(token, 100000);//更新session时间
		
		return TaotaoResult.ok(JsonUtils.jsonToPojo(json, TbUser.class));
	}

}
