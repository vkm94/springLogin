package com.model;

import java.awt.List;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.employe;

import com.repo.empRepo;

@Service
public class emp_model {
	@Autowired
	empRepo er;
	public String register(employe e) {
		try{
			if(er.save(e) != null) {
		
			System.out.println("added");
			return "added";
		}else {
			System.out.println("error");
			return "Error";
		}}
	catch(Exception e1){
		e1.printStackTrace();
		return null;
	}
		
	
		
	}
	public  java.util.List<employe>  getAll() {
		
		LocalDate date=LocalDate.now();
		LocalDate d1=date.plusDays(10);
	String date2=date.toString();
	String date1=d1.toString();
		try {
			
			java.util.List<employe> ul=er.getDataByDate(date2,date1);
			
			return ul;
		}catch(Exception e2) {
			e2.printStackTrace();
			
		}
		List  ul=null;
		return null ;
		
	}
	public String login(String name, String password) {
		String result=er.findbyname(name,password);
		if(result != null) {
			return "Success";
		}
		
		return "Error";
	}
	
	

}
