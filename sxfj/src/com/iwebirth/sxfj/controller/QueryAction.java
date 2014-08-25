package com.iwebirth.sxfj.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iwebirth.sxfj.jackson.Jackson;

@Controller
@RequestMapping("/query")
public class QueryAction {
	private ObjectMapper mapper = Jackson.getMapper();
	@RequestMapping(params="tree")
	public void LoadCompanyTree(HttpServletRequest request, HttpServletResponse response,@RequestParam(required=false)String node) throws IOException{
		if(node != null)
			System.out.println("node:"+node);
		String str = "";
		if("root".equals(node)){
			List<Map<String,Object>> childrenList = new ArrayList<>();
			Map<String,Object> map1 = new HashMap<>();
			Map<String,Object> map2 = new HashMap<>();
			map1.put("id", 1);
			map1.put("text", "浙江");
			//map1.put("qtip", "这是第一个叶子");
			//map1.put("leaf", true);
			//map1.put("loaded", true);
			map2.put("id", 2);
			map2.put("text", "江苏");
			//map2.put("leaf", true);
			childrenList.add(map1);
			childrenList.add(map2);
			str = mapper.writeValueAsString(childrenList);
		}else{
			int node_index =Integer.valueOf(node);
			System.out.println("node_index:"+node_index);
			switch(node_index){
				case 1:			
				List<Map<String,Object>> childrenList = new ArrayList<>();
				Map<String,Object> map1 = new HashMap<>();
				Map<String,Object> map2 = new HashMap<>();
				map1.put("id", 3);
				map1.put("text", "绍兴");
				map1.put("qtip", "绍兴");
				map1.put("leaf", true);
				map2.put("id", 4);
				map2.put("text", "杭州");
				map2.put("leaf", true);
				childrenList.add(map1);
				childrenList.add(map2);
				str = mapper.writeValueAsString(childrenList);
				break;
				case 2:	break;
			}
		}
		System.out.println(str);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(str);
	}
	@RequestMapping(params="tree1")
	public void tree(HttpServletRequest request, HttpServletResponse response,@RequestParam(required=false)String node) throws IOException{
		if(node != null)
			System.out.println("node:"+node);		
		String str = "[{ \"id\": 1, \"text\": \"Phil\", \"leaf\": true },{ \"id\": 2, \"text\": \"Nico\", \"expanded\": true, \"children\": [{ \"id\": 3, \"text\": \"Mitchell\", \"leaf\": true }]},{ \"id\": 4, \"text\": \"Sue\", \"loaded\": true }]";
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(str);
	}
}
