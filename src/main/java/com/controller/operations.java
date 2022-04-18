package com.controller;



import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.entity.employe;
import com.service.emp_service;

@RestController
@RequestMapping("/mainapp")
public class operations {
	
	@Autowired
	emp_service er;
@PostMapping("/register")
	String register(employe e){
	
		String result=null;
		try {
			result = er.register(e);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return result;
		
	}
@PostMapping("/userlogin")
public ModelAndView login(@RequestParam String name,@RequestParam String password,ModelMap mp,HttpSession session) {
	
	String check=er.login(name,password);
	if(check.equals("Success")) {
	
		ModelAndView mv=new ModelAndView();
		mp.put("data", "Success");
		session.setAttribute(name, "name");
		mv.setViewName("redirect:./emplist");
		return mv;
	
	}else {
		mp.put("data", "Error");
		ModelAndView mv=new ModelAndView();
		//mv.setViewName("login");
		return mv;
	}

}

}
