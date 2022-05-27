package com.controller;



import java.awt.PageAttributes.MediaType;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Users;
import com.entity.employe;
import com.service.emp_service;
import com.service.userService;

@RestController
@RequestMapping("/mainapp")
@Validated
public class operations {
	
	
	@Autowired
	emp_service er;
	@Autowired
	userService us;
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



//@PostMapping("/addUser")


}
