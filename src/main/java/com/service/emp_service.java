package com.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.employe;
import com.model.emp_model;

@Service

public class emp_service {
@Autowired
emp_model em;
	public  String register(employe e) {
if( e.getPassword().equals(e.getC_password())){
	String result=em.register(e);
	return result;
}else {
	return "Password mismatch";
}
}
	
	public   List<employe> getList() {
		 List<employe>  result=em.getAll();
		 //System.out.println(result.get(0));
		return result;
	}

	public String login(String name, String password) {
		System.out.println(em.login(name,password));
		return em.login(name,password);
	}

}
