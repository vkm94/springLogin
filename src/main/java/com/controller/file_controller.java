package com.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Appointment;
import com.entity.Users;
import com.entity.employe;
import com.service.AppointmentService;
import com.service.emp_service;
import com.service.userService;

@Controller
@RequestMapping("/mainapp")
public class file_controller {
	@Autowired
	emp_service er;
	@Autowired
	userService us ;
	
	// private static Logger logger  = Logger.getLogger(Controller.class);
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
	if(session != null) {
		
	
		 List<employe>  result=er.getList();
			
		 mp.put("result", result);
		 //logger.info("Error");
		return "emplist";
	}
	return "login";
		
		//return "login";
	}
	
		
		
	@GetMapping("/login")
	public String login1() {
		
		return "login";
		
	}
	
	@PostMapping("/userlogin")
	public String login(@RequestParam String email,@RequestParam String password,ModelMap mp,HttpSession session) {
		ModelAndView mv=new ModelAndView();
	
		if(us.login(email,password) != null) {
			List<Users> check=us.login(email,password);
			System.out.println(check.toString());
			if(check.get(0).getRole().equals("admin")) {
				int id=check.get(0).getId();
				mp.put("data", check);
					
				return "admin";
				
				
			}
			else {
				
				mp.put("data", check);
				return "user";
				
				
			}
			
		}else {
			return "login";
		}
		
//		if(check.equals("Success")) {
	//	
//			ModelAndView mv=new ModelAndView();
//			mp.put("data", "Success");
//			session.setAttribute(email, "name");
//			mv.setViewName("redirect:./emplist");
//			return mv;
	//	
//		}else {
//			mp.put("data", "Error");
//			ModelAndView mv=new ModelAndView();
//			//mv.setViewName("login");
//			return mv;
//		}

	}
	@GetMapping("/admin")
	public String Adminprofile(ModelMap mp) {
		
		return "admin";
		
	}
	@GetMapping("/user")
	public String Userprofile() {
		
		return "user";
		
	}
	@GetMapping("/add_user/{id}")
	public String Add_User(@PathVariable String adminid){
		ModelMap mp=new ModelMap();
		mp.put("adminid",adminid );
		return "adduser";
	}
	@PostMapping("/add_admin")
public String addAdmin( @Valid @ModelAttribute("users") Users user,BindingResult result, Model model ) {
		
		
		if (result.hasErrors()) {
			
			System.out.println(result);
			return "adduser";
		    }
	

		else {
			String  phonenumber=user.getPhone();
			System.out.println(user.getPhone());
	String name=user.getName();
	//
		String email=user.getEmail();
		String password=user.getPassword();
		
		String address=user.getAddress();
	String admin_id=user.getAdmin_id();
		String contact=user.getContact();
	
			
		us.addAdmin(name,email,password,phonenumber,address,admin_id,contact);
		return "adduser";
		}
	}
	
	@PostMapping("/add_user")
	public String addUser( @Valid @ModelAttribute("users") Users user,BindingResult result, Model model ) {
		
		
		if (result.hasErrors()) {
			
			System.out.println(result);
			return "adduser";
		    }
	

		else {
			String  phonenumber=user.getPhone();
			System.out.println(user.getPhone());
	String name=user.getName();
	//
		String email=user.getEmail();
		String password=user.getPassword();
		
		String address=user.getAddress();
	String admin_id=user.getAdmin_id();
		String contact=user.getContact();
	
			
		us.add(name,email,password,phonenumber,address,admin_id,contact);
		return "adduser";
		}
	}
	@Autowired
	AppointmentService as;
	
	@GetMapping("/myUsers/{id}")
	public String myaUsers( ModelMap mp,@PathVariable("id") String id) {
		List<Users> result= us.getUSers(id);
		System.out.println(result.toString());
		 mp.put("result", result);
		return "myusers";
		
	}
	@GetMapping("/doc/{id}")
	public String DoctorAppointment( ModelMap mp,@PathVariable("id") int id) {
		List<Appointment> result1= as.docApointments(id);
		System.out.println(result1.toString());
		 mp.put("resultdoc", result1);
		return "MyAppointment";
		
	}
	@GetMapping("myUsers/edit/{id}")
	public String editUser( ModelMap mp,@PathVariable("id") int id) {
		List<Users> list= us.editUser(id);
		
		System.out.println(list.toString());
		 mp.put("result", list);
		return "editUser";
		
	}
	
	@PostMapping("myUsers/edit/{id}")
	public String editUserDetails( ModelMap mp,@PathVariable("id") int id,Users user) {
		List<Users> list= us.editUser(id,user);
		
		//System.out.println(list.toString());
		 mp.put("result", list);
		return "editUser";
		
	}
	
	@GetMapping("myUsers/delete/{id}")
	public String deleteUser( ModelMap mp,@PathVariable("id") int id) {
		us.deleteUser(id);
		return "myusers";
		
	}
	@PostMapping("/bookappointment")
	public String BookAppointment(Appointment ap) {
		as.bookAppointment(ap);
		return "user";
		
	}
	@GetMapping("/listAppoint/{id}")
	public String ListAppoint(ModelMap mp, @PathVariable("id") int id) {
		List<Appointment> list2=as.ListAppoints(id);
		mp.put("list2", list2);
		return "myappoints";
		
	}
	
}
