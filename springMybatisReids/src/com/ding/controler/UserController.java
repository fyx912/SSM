package com.ding.controler;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


//类注解、表示这个类使用注解的形式、会被springMVC扫描到  
@Controller
public class UserController {
	
	@RequestMapping(value="userInfo/{id}",method=RequestMethod.GET,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object userInfo(@PathVariable("id") int id){
		 Map<String,Object> map = new HashMap<String,Object>();
		 map.put("code", 0);
		 map.put("id", id);
		 map.put("message","你好 spring MVC");
		return map;
	}
	
	@RequestMapping(value="userInfo",method=RequestMethod.GET,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<String,Object> userInfo(){
		 Map<String,Object> map = new HashMap<String,Object>();
		 map.put("code", 0);
		 map.put("message","spring MVC");
		return map;
	}

	@RequestMapping(value="userInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> userInfo(HttpServletRequest request){
		String data = "";
        StringBuffer sbr = new StringBuffer();
        try {
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            while ((line = reader.readLine()) != null) {
                sbr.append(line);
            }
            data = sbr.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(" spring mvc restful post="+data);
		 Map<String,Object> map = new HashMap<String,Object>();
		 map.put("code", 0);
		 map.put("data", data);
		 map.put("message","spring MVC");
		return map;
	}
	
	@RequestMapping(value="userInfo",method=RequestMethod.PUT)
	@ResponseBody
	public Map<String,Object> userInfoPut(HttpServletRequest request){
		String data = "";
        StringBuffer sbr = new StringBuffer();
        try {
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            while ((line = reader.readLine()) != null) {
                sbr.append(line);
            }
            data = sbr.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(" spring mvc restful PUT="+data);
		 Map<String,Object> map = new HashMap<String,Object>();
		 map.put("code", 0);
		 map.put("data", data);
		 map.put("message","spring MVC");
		return map;
	}
}
