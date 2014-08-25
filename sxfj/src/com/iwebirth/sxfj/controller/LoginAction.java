package com.iwebirth.sxfj.controller;


import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iwebirth.sxfj.model.UserModel;
import com.iwebirth.sxfj.service.LoginService;

@Controller
@RequestMapping("/")
public class LoginAction {
	@Resource(name="loginService")
	LoginService loginService;
	@RequestMapping
	public String visit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//在这边增加cookie和session			
		return "index";
	}
	//@RequestParam(URL参数)@CookieValue(Cookie参数)@RequestHeader(头部参数)
	@RequestMapping(params="logincheck",method=RequestMethod.POST)
	public ModelAndView loginCheck(HttpServletRequest request,HttpServletResponse response,UserModel model) throws Exception{
		request.setCharacterEncoding("utf-8");response.setContentType("text/html;character=utf-8");
		Enumeration<?> headers = request.getHeaderNames();
		String username = (String)model.getUsername();
		String password = (String)model.getPassword();
		System.out.println("username:"+username);
		JSONObject result = loginService.loginCheck(username,password);	
		response.getWriter().write(result.toString());
		return null;
	}
	@RequestMapping(params="loginin")
	public String loginIn(HttpServletRequest request,HttpServletResponse response) throws Exception{
		return "app";
	}

}
