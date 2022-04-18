package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="employe")
@Table(name="employe")
public class employe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private int emp_id;
	private String name;
	private String password;
	private String c_password;
	private String address;
	private String bdte;
	private String joindate;
	private int exp;
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getC_password() {
		return c_password;
	}
	public void setC_password(String c_password) {
		this.c_password = c_password;
	}
	public String getaddress() {
		return address;
	}
	public void setaddress(String address) {
		this.address = address;
	}
	public String getBdte() {
		return bdte;
	}
	public void setBdte(String bdte) {
		this.bdte = bdte;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	
	public employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public employe(int emp_id, String name,  String address, String bdte,String joindate, int exp) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		
		this.address = address;
		this.bdte = bdte;
		this.joindate = joindate;
		this.exp = exp;
	}
	public employe(int emp_id, String name, String password, String c_password, String address, String bdte,String joindate, int exp) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.password = password;
		this.c_password = c_password;
		this.address = address;
		this.bdte = bdte;
		this.joindate = joindate;
		this.exp = exp;
	}
	

	@Override
	public String toString() {
		return "employee [emp_id=" + emp_id + ", name=" + name + ", password=" + password + ", c_password=" + c_password
				+ ", address=" + address + ", bdte=" + bdte + ", joindate=" + joindate + ", exp=" + exp + "]";
	}

}
