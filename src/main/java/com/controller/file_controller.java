package com.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.employe;
import com.service.emp_service;

@Controller
@RequestMapping("/mainapp")
public class file_controller {
	@Autowired
	emp_service er;

	 private static Logger logger  = Logger.getLogger(Controller.class);
	@GetMapping("/")
public String login() {
		return "login";
	
}
	@GetMapping("/register")
public String register() {
		return "register";
	
}
	@GetMapping("/emplist")
	public String getList(ModelMap mp,HttpSession session) {
	
		 List<employe>  result=er.getList();
			
		 mp.put("result", result);
		 logger.info("Error");
		return "emplist";
	
		
		//return "login";
	}
	
		
	
	

	
		
		
	@GetMapping("/login")
	public String login1() {
		
		return "login";
		
	}
	
}
