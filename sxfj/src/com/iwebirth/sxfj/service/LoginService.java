package com.iwebirth.sxfj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import com.iwebirth.sxfj.model.UserModel;

@Service("loginService")
public class LoginService {
	@Autowired
	private SessionFactory sf;
	public JSONObject loginCheck(String username,String password){
		Session session = sf.getCurrentSession();
		Criteria c = session.createCriteria(UserModel.class);
		c.setProjection(Projections.property("password")).add(Restrictions.eq("username", username)); //select u.password from user where username = "";
		List<String> lPassword = c.list();
		Map<String,String> resultMap = new HashMap<>();
		if(lPassword.size() == 0){
			resultMap.put("result", "false");//没有该用户名
		}else{
			if(!password.equals(lPassword.get(0))){
				resultMap.put("result","false");//密码错误
			}else{
				resultMap.put("result", "true");
			}
		}
		JSONObject jo = JSONObject.fromObject(resultMap);
		return jo;
	}
}
