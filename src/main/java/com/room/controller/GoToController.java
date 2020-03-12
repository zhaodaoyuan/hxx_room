package com.room.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.room.pojo.User;

@Controller
public class GoToController {
	@RequestMapping("/")
	public String tologin() {
		return "login";
	}
	@RequestMapping("/dologin")
	@ResponseBody
	public boolean admin(User user) {
		if(user.getUsername().equals("admin")) {
			if(user.getPassword().equals("admin")) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
}
