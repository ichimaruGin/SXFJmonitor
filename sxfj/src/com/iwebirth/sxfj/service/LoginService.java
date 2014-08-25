package com.iwebirth.sxfj.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import com.iwebirth.sxfj.jackson.Jackson;
import com.iwebirth.sxfj.model.UserModel;

@Service("loginService")
public class LoginService {
	@Autowired
	private SessionFactory sf;
	private ObjectMapper mapper = Jackson.getMapper();
	public String loginCheck(String username,String password) throws JsonGenerationException, JsonMappingException, IOException{
		Session session = sf.getCurrentSession();
		Criteria c = session.createCriteria(UserModel.class);
		c.setProjection(Projections.property("password")).add(Restrictions.eq("username", username)); //select u.password from user where username = "";
		List<String> lPassword = c.list();
		Map<String,Object> resultMap = new HashMap<>();
		if(lPassword.size() == 0){
			resultMap.put("result", false);//没有该用户名
		}else{
			if(!password.equals(lPassword.get(0))){
				resultMap.put("result",false);//密码错误
			}else{
				resultMap.put("result", true);
			}
		}
		String ret = mapper.writeValueAsString(resultMap);
		return ret;
	}
}
